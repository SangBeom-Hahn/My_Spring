package hello.springtx.order;

public enum PayStatus {
    COMP("정상"),
    WAIT("대기");

    public String desc;

    PayStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
