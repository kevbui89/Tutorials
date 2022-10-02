package com.googleguiceproviders.assisted.exceptions;

public class ClearanceException extends Exception {

  /**
   * Creates a new instance of <code>ClearanceException</code> without detail
   * message.
   */
  public ClearanceException() {
  }

  /**
   * Constructs an instance of <code>ClearanceException</code> with the
   * specified detail message.
   *
   * @param msg the detail message.
   */
  public ClearanceException(String msg) {
    super(msg);
  }
}
