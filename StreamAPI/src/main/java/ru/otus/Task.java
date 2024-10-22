package ru.otus;

public class Task {
    private long id;
    private String title;
    private Status status;

    public Task(long id, String title, Status status) {
        this.id = id;
        this.title = title + "_" + id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
