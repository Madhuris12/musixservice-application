package com.stackroute.musixservice.response;

public class ResponseForError {
    private int errorID;
        private String errorMessageInformation;

        public void setErrorMessageInformation(String errorMessageInformation) {
            this.errorMessageInformation = errorMessageInformation;
        }

        public String getErrorMessageInformation() {
            return errorMessageInformation;
        }

        public void setErrorID(int errorID) {
            this.errorID = errorID;
        }

        public int getErrorID() {
            return errorID;
        }
    }