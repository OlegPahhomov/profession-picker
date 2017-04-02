package application.picker;

import java.util.List;

public class Result<T> {

  protected boolean ok;
  protected T data;
  protected Object message;

  public Result(boolean ok, T data) {
    this.ok = ok;
    this.data = data;
  }

  public Result(boolean ok, T data, Object message) {
    this.ok = ok;
    this.data = data;
    this.message = message;
  }

  public boolean isOk() {
    return ok;
  }

  public T getData() {
    return data;
  }

  public Object getMessage() {
    return message;
  }

  public static List<Result> ok(List<Result> results) {
    results.add(ok());
    return results;
  }

  public static Result ok() {
    return new Result(true, null, null);
  }

  public static Result ok(Object data) {
    return new Result(true, data, null);
  }

  public static Result ok(Object data, Object message) {
    return new Result(true, data, message);
  }

  public static Result nok() {
    return new Result(false, null, null);
  }

  public static Result nok(Object data) {
    return new Result(false, data, null);
  }

  public static Result nok(Object data, Object message) {
    return new Result(false, data, message);
  }

}