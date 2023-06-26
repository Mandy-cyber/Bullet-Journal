/**
 * Contains all the data used needed to build and use the module.
 */
module cs3500.pa05 {
  requires javafx.controls;
  requires javafx.fxml;

  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;

  requires org.controlsfx.controls;
  requires java.desktop;

  opens cs3500.pa05 to javafx.fxml;

  opens cs3500.pa05.model.settings to com.fasterxml.jackson.databind;
  opens cs3500.pa05.model.entries to com.fasterxml.jackson.databind;

  exports cs3500.pa05;
  exports cs3500.pa05.controller;
  exports cs3500.pa05.model;
  exports cs3500.pa05.model.io;
  exports cs3500.pa05.model.entries;
  exports cs3500.pa05.model.settings;
  exports cs3500.pa05.view;
  exports cs3500.pa05.json;
  exports cs3500.pa05.controller.popup;

  opens cs3500.pa05.controller to javafx.fxml;
  opens cs3500.pa05.controller.popup to javafx.fxml;
}



