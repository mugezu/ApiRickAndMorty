package com.example.AwesomeCompan.demo.model;

public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;

    public Info() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Info{" +
                "count=" + count +
                ", pages=" + pages +
                ", next='" + next + '\'' +
                ", prev='" + prev + '\'' +
                '}';
    }
}
