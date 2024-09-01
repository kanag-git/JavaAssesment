package assessment.email.domain;

/**
 * This class holds email related properties
 *
 * @author Kanagarajan
 */
public final class Email {

    private String body;

    private ServiceType serviceType;

    public Email(String body, ServiceType serviceType) {
        this.body = body;
        this.serviceType = serviceType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("body='").append(body).append('\'');
        sb.append(", serviceType=").append(serviceType);
        sb.append('}');
        return sb.toString();
    }
}
