package application.sector;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * container of application messages for the user
 */
public class MessageContainer implements Serializable{
  private static final long serialVersionUID = 7499353292097505872L;

  private Set<String> successes = new LinkedHashSet<>();
  private Set<String> errors = new LinkedHashSet<>();
  private Set<String> notifications = new LinkedHashSet<>();

  public Set<String> getSuccesses() {
    return successes;
  }

  public void setSuccesses(Set<String> successes) {
    this.successes = successes;
  }

  public Set<String> getErrors() {
    return errors;
  }

  public void setErrors(Set<String> errors) {
    this.errors = errors;
  }

  public Set<String> getNotifications() {
    return notifications;
  }

  public void setNotifications(Set<String> notifications) {
    this.notifications = notifications;
  }

  public MessageContainer addSuccess(String message) {
    successes.add(message);
    return this;
  }

  public MessageContainer addError(String message) {
    errors.add(message);
    return this;
  }

  public MessageContainer addNotification(String message) {
    notifications.add(message);
    return this;
  }

  public boolean hasSuccesses() {
    return successes.size() > 0;
  }

  public boolean hasErrors() {
    return errors.size() > 0;
  }

  public boolean hasNotifications() {
    return notifications.size() > 0;
  }

}
