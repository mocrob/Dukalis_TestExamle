package ru.ftc.android.shifttemple.features.tasks.domain.model;

import ru.ftc.android.shifttemple.features.login.domain.model.User;

public final class Task {
    public String address;
    public String createDataTime;
    public String descriptionFull;
    public String descriptionShort;
    public User employer;
    public User executor;
    public int id;
    //public Enum status;
    public String status;
    public String updateDateTime;

    public Task(int id, String address)
    {
        this.address = address;
        this.id = id;
    }
    public Task(String descriptionShort, String descriptionFull, String address)
    {
        this.descriptionShort = descriptionShort;
        this.descriptionFull = descriptionFull;
        this.address = address;
        this.createDataTime = null;
        this.employer = null;
        this.executor = null;
        this.id = 0;
        this.status = null;
        this.updateDateTime = null;
    }
    public Task(String address, String createDataTime, String descriptionFull, String descriptionShort,
                User employer, User executor, int id, String status, String updateDateTime) {
        this.address = address;
        this.createDataTime = createDataTime;
        this.descriptionFull = descriptionFull;
        this.descriptionShort = descriptionShort;
        this.employer = employer;
        this.executor = executor;
        this.id = id;
        this.status = status;
        this.updateDateTime = updateDateTime;
    }

    public String getAddress() {
        return address;
    }

    public String getCreateDataTime() {
        return createDataTime;
    }

    public String getDescriptionFull() {
        return descriptionFull;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public User getEmployer() {
        return employer;
    }

    public User getExecutor() {
        return executor;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }
}
