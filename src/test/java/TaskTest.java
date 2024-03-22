import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void shouldTestSimpleTaskMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;


        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void ShouldTestSimpleTaskNotMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Купить");
        boolean expected = false;


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldGetTitle() {
        SimpleTask simpleTask = new SimpleTask(3, "Привет");
        String title = simpleTask.getTitle();
        Assertions.assertEquals("Привет", title);

    }

    @Test
    public void ShouldGetSubtasks() {
        String[] expectedSubtasks = {"subtask1", "subtask2", "subtask3"};
        Epic epic = new Epic(1, expectedSubtasks);

        String[] actualSubtasks = epic.getSubtasks();

        assertArrayEquals(expectedSubtasks, actualSubtasks);
    }

    @Test
    public void ShouldTestEpicMatches() {
        String[] subtasks = {"Subtask 1", "Subtask 2", "Subtask 3"};
        Epic epic = new Epic(1, subtasks);

        assertTrue(epic.matches("Subtask 1"));
        assertTrue(epic.matches("Subtask 2"));
        assertTrue(epic.matches("Subtask 3"));
        assertFalse(epic.matches("Subtask 4"));
    }

    @Test
    public void ShouldGetTopicProjectStart() {
        Meeting meeting = new Meeting(1, "NoTopic", "NoProject", "NoStart");
        String topic = meeting.getTopic();
        String project = meeting.getProject();
        String start = meeting.getStart();

        Assertions.assertEquals("NoTopic", topic);
        Assertions.assertEquals("NoProject", project);
        Assertions.assertEquals("NoStart", start);
    }

    @Test
    public void ShouldTestMeetingMatch() {
        Meeting meeting = new Meeting(1, "Dating", "Lola", "EightPM");

        assertTrue(meeting.matches("Dating"));
        assertTrue(meeting.matches("Lola"));
        assertFalse(meeting.matches("noTopic"));
        assertFalse(meeting.matches("noProject"));

    }


}


