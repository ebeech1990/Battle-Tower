package battletower.persistence;

import battletower.Trainers;

public class UserAccount
{
    Long id;
    String userName;
    Trainers userTrainer;

    public UserAccount()
    {
    }

    public UserAccount(Long id, String userName, Trainers userTrainer)
    {
        this.id = id;
        this.userName = userName;
        this.userTrainer = userTrainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Trainers getUserTrainer() {
        return userTrainer;
    }

    public void setUserTrainer(Trainers userTrainer) {
        this.userTrainer = userTrainer;
    }
}
