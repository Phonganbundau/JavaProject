package com.example.javaproject;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.geometry.Pos;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class AccountUpdateScreen {

    public static VBox getAccountUpdateLayout() {
        // Main container
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.getStyleClass().add("main-profile-layout");

        // Header Section
        BorderPane header = new BorderPane();
        header.setPrefHeight(200);
        header.getStyleClass().add("header-background");

        // Avatar and Info in the Center
        VBox centerBox = new VBox(10);
        centerBox.setAlignment(Pos.CENTER);

        ImageView avatar = new ImageView(new Image(AccountUpdateScreen.class.getResourceAsStream("/com/example/javaproject/avatar.png")));
        avatar.setFitHeight(100);
        avatar.setFitWidth(100);
        avatar.getStyleClass().add("user-avatar");

        Label nameLabel = new Label("John Doe");
        nameLabel.getStyleClass().add("user-name");

        Label statusLabel = new Label("\"I wish I could be 17 Again.\"");
        statusLabel.getStyleClass().add("user-status");

        Label onlineStatusLabel = new Label("Online");
        onlineStatusLabel.getStyleClass().add("user-online-status");

        centerBox.getChildren().addAll(avatar, nameLabel, statusLabel, onlineStatusLabel);
        header.setCenter(centerBox);

        // Buttons on the Top-Right
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.TOP_RIGHT);
        buttonBox.setPadding(new Insets(10));

        Button editProfileButton = new Button("Edit Profile");
        editProfileButton.getStyleClass().add("edit-profile-button");
        editProfileButton.setOnAction(e -> {
            VBox personalInfoForm = getPersonalInfoForm();
            mainLayout.getChildren().clear();
            mainLayout.getChildren().add(personalInfoForm);
        });

        Button changePasswordButton = new Button("Change Password");
        changePasswordButton.getStyleClass().add("change-password-button");
        changePasswordButton.setOnAction(e -> {
            VBox changePasswordForm = getChangePasswordForm();
            mainLayout.getChildren().clear();
            mainLayout.getChildren().add(changePasswordForm);
        });

        buttonBox.getChildren().addAll(editProfileButton, changePasswordButton);
        header.setTop(buttonBox);

        // Information Section
        VBox infoSection = new VBox(15);
        infoSection.setAlignment(Pos.TOP_LEFT);
        infoSection.setPadding(new Insets(20));
        infoSection.getStyleClass().add("info-section");

        // Add Information Fields
        infoSection.getChildren().addAll(
                createInfoField("Mobile:", "+91 9876 453 210"),
                createInfoField("Email:", "johndoe@example.com"),
                createInfoField("Gender:", "Male"),
                createInfoField("Location:", "New York, USA"),
                createInfoField("Birthdate:", "7th December, 1994")
        );

        // Add sections to main layout
        mainLayout.getChildren().addAll(header, infoSection);
        mainLayout.getStylesheets().add(AccountUpdateScreen.class.getResource("/com/example/javaproject/styles_account_update.css").toExternalForm());

        return mainLayout;
    }

    private static HBox createInfoField(String label, String value) {
        Label fieldLabel = new Label(label);
        fieldLabel.getStyleClass().add("info-label");

        Label fieldValue = new Label(value);
        fieldValue.getStyleClass().add("info-value");

        HBox infoField = new HBox(10, fieldLabel, fieldValue);
        infoField.setAlignment(Pos.CENTER_LEFT);
        return infoField;
    }

    private static VBox getPersonalInfoForm() {
        VBox formLayout = new VBox(10);
        formLayout.setPadding(new Insets(20));
        formLayout.setAlignment(Pos.TOP_LEFT);
        formLayout.getStyleClass().add("form-layout");

        Label title = new Label("Edit Personal Information");
        title.getStyleClass().add("form-title");

        Label fullNameLabel = new Label("Full Name:");
        fullNameLabel.getStyleClass().add("form-label");
        TextField fullNameField = new TextField();
        fullNameField.getStyleClass().add("form-field");

        Label emailLabel = new Label("Email:");
        emailLabel.getStyleClass().add("form-label");
        TextField emailField = new TextField();
        emailField.getStyleClass().add("form-field");

        Label addressLabel = new Label("Address:");
        addressLabel.getStyleClass().add("form-label");
        TextField addressField = new TextField();
        addressField.getStyleClass().add("form-field");

        Label dobLabel = new Label("Date of Birth:");
        dobLabel.getStyleClass().add("form-label");
        TextField dobField = new TextField();
        dobField.getStyleClass().add("form-field");

        Button saveButton = new Button("Save Changes");
        saveButton.getStyleClass().add("save-button");
        saveButton.setOnAction(e -> {
            // Save personal info logic
            showAlert(Alert.AlertType.INFORMATION, "Saved", "Your information has been updated.");
        });

        formLayout.getChildren().addAll(title, fullNameLabel, fullNameField, emailLabel, emailField, addressLabel, addressField, dobLabel, dobField, saveButton);
        return formLayout;
    }

    private static VBox getChangePasswordForm() {
        VBox formLayout = new VBox(10);
        formLayout.setPadding(new Insets(20));
        formLayout.setAlignment(Pos.TOP_LEFT);
        formLayout.getStyleClass().add("form-layout");

        Label title = new Label("Change Password");
        title.getStyleClass().add("form-title");

        Label oldPasswordLabel = new Label("Old Password:");
        oldPasswordLabel.getStyleClass().add("form-label");
        PasswordField oldPasswordField = new PasswordField();
        oldPasswordField.getStyleClass().add("form-field");

        Label newPasswordLabel = new Label("New Password:");
        newPasswordLabel.getStyleClass().add("form-label");
        PasswordField newPasswordField = new PasswordField();
        newPasswordField.getStyleClass().add("form-field");

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.getStyleClass().add("form-label");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.getStyleClass().add("form-field");

        Button saveButton = new Button("Update Password");
        saveButton.getStyleClass().add("save-button");
        saveButton.setOnAction(e -> {
            if (newPasswordField.getText().equals(confirmPasswordField.getText())) {
                // Update password logic
                showAlert(Alert.AlertType.INFORMATION, "Success", "Your password has been updated.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Passwords do not match.");
            }
        });

        formLayout.getChildren().addAll(title, oldPasswordLabel, oldPasswordField, newPasswordLabel, newPasswordField, confirmPasswordLabel, confirmPasswordField, saveButton);
        return formLayout;
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
