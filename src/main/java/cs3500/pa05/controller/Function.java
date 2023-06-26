package cs3500.pa05.controller;

/**
 * Functional interface used to send functions as arguments.
 */
@FunctionalInterface
public interface Function {
  /**
   * Applies the given method.
   */
  void apply();
}
