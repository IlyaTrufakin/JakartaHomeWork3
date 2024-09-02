package itstep.learning.filters;

public class StatusCodeInfo {
    private final int statusCode;
    private final String statusMessage;
    private final String statusCodeFamily;
    public StatusCodeInfo(int statusCode, String statusMessage, String statusCodeFamily) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.statusCodeFamily = statusCodeFamily;
    }


    public int getStatusCode() {
        return statusCode;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public String getStatusCodeFamily() {
        return statusCodeFamily;
    }


    @Override
    public String toString() {

        return String.format(
                "Статус выполнения запроса: { код=%d, сообщение='%s', семейство='%s' }",
                statusCode, statusMessage, statusCodeFamily);

    }
}
