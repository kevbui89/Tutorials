package com.googleguiceproviders.assisted.exceptions;

public class ProbeException extends Exception {

  /**
   * Creates a new instance of <code>ProbeException</code> without detail
   * message.
   */
  public ProbeException() {
  }

  /**
   * Constructs an instance of <code>ProbeException</code> with the specified
   * detail message.
   *
   * @param msg the detail message.
   */
  public ProbeException(String msg) {
    super(msg);
  }
}