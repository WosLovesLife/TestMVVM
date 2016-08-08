package com.wosloveslife.testmvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class ObservableUser extends BaseObservable{
    private String firstName;
    private String lastName;

    public ObservableUser(){
    }

    public ObservableUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(com.wosloveslife.testmvvm.BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(com.wosloveslife.testmvvm.BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }
}