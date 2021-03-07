package br.com.rafaelfaustini.srpg.entity;

public class Campaign {
    private int id;
    private String name;
    private String story;

    public Campaign(int id, String name, String story) {
        this.id = id;
        this.name = name;
        this.story = story;
    }
    public Campaign(String name, String story) {
        this.name = name;
        this.story = story;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

}
