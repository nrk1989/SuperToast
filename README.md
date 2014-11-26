SuperToast
==========

Context sensual toasts for android.

Overview
--------
**SuperToast** is a utility class that can be used by Android Developers whose needs to show the toasts wrapped within the actual context. 

A SuperToast will be displayed at the top postiion of an application window.

Usage 
--------
The API is kept as simple as the Toast API.

Create a instance:

      SuperToast mSuperToast=new SuperToast(Context);

Show the Info Toast: 

    mSuperToast.showShortInfoToast("Info Toast");

Show the Error Toast:

    mSuperToast.showShortErrorToast("Error toast");

Hide the Toast:

    mSuperToast.hideToast();

Important:
--------
Make sure to call **hideToast()** in onPause() to cancel all the action remaining toasts.

Basic Samples
--------

![Info Toast](https://github.com/nrk1989/SuperToast/blob/master/Resources/Toast_Info.png)

![Error Toast](https://github.com/nrk1989/SuperToast/blob/master/Resources/Toast_Error.png)
