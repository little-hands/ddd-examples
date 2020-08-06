package com.littlehands.task_management.good_example.domain.task;

import com.littlehands.task_management.good_example.domain.shared.DomainException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class TaskTest {

  @Nested
  class ConstructorTest {
    @Test
    protected void タスク新規作成時() {
      // when: タスク名と期日を指定してタスクを生成すると
      String taskName = "タスク名";
      LocalDate dueDate = LocalDate.of(2020, 8, 1);
      Task task = new Task(taskName, dueDate);

      // then:
      // タスク名と期日は引数の値で生成される
      assertEquals(task.getName(), taskName);
      assertEquals(task.getDueDate(), dueDate);

      // 延期回数とステータスは初期状態として0回と未完了
      assertEquals(task.getPostponeCount(), 0);
      assertEquals(task.getTaskStatus(), TaskStatus.UNDONE);
    }
  }

  @Nested
  class PostponeTest {
    @Test
    protected void タスク延期1回目が成功し_延期回数が1増えて期日が1日後になる() {
      // given: 延期回数0回のタスク
      LocalDate dueDate = LocalDate.of(2020, 8, 1);
      Task task = new Task("taskName", dueDate);

      // when: タスクを延期すると
      task.postpone();

      // then:
      assertEquals(task.getPostponeCount(), 1);
      assertEquals(task.getDueDate(), dueDate.plusDays(1));
    }

    @Test
    protected void タスクの4回目の延期が失敗する() {
      // given: 3回延期されているタスク
      LocalDate dueDate = LocalDate.of(2020, 8, 1);
      Task task = new Task("taskName", dueDate);
      task.postpone();
      task.postpone();
      task.postpone();

      // when: タスクを延期すると
      Executable target = () -> task.postpone();

      // then: 例外が発生する
      DomainException exception = assertThrows(DomainException.class, target);
      assertEquals(exception.getMessage(), "最大延期回数を超えています");
    }
  }

  @Nested
  class DoneTest {
    @Test
    protected void タスクを完了させるとステータスが完了状態になる() {
      // given: 新規生成状態のタスク
      Task task = new Task("taskName", LocalDate.now());

      // when:
      task.done();

      // then:
      assertEquals(task.getTaskStatus(), TaskStatus.DONE);
    }
  }
}
