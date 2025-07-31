package org.example;

class wiseSaying {
    private int id;
    private String text;
    private String author;

    public wiseSaying(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%d / %s / %s", this.id, this.author, this.text);
    }
}
