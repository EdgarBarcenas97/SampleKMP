# Android Stori Technical Test
An application must be made that allows user registration, user login, displaying a list of tracks and their details with all the information.

## :scroll: Problem to solve

In this application we show a list of tracks to be able to see the details of the track
The problems to be solved are the following:
The first view is the one corresponding to the application login, and contains a
text field for the username, a text field for the password, a login button, and a record
Button. The challenge to complete on this screen will be the following:
- Validate username and password data.
- When you press the registration option, the registration screen should be displayed,
which will be the beginning of Onboarding.

The registration process must consist of the following views:
- User data: Email, password, first name, last name

- Home Screen: It will be the main screen, which the user accesses once they
perform a successful login.
- We have a table of users and another of tracks in Room

## :paperclip:  Technologies and topics used

### Technologies
- Kotlin
- Ktor
- Corrutines
- Koin
- Room
- Settings Multiplatform
- Compose
- Data Storage Preferences
- Coil
- mockitoKotlin
- material3
- devtools-ksp
- google-services

### Topics
- Clean Architecture
- Clean Code
- SOLID
- MVVM patten
- Repository pattern
- Dependency injection

## :floppy_disk: Firebase

### Authentication
To manage user login, authentication with email and password stored in the room was used.

Onboarding Android | Onboarding iOS
--- | --- 
<img src="https://github.com/user-attachments/assets/cf42b616-ef34-4044-968c-6bafbe80ef0c" width="220"> | <img src="https://github.com/user-attachments/assets/7cb8ac72-7e6f-48c9-ac6d-0ef267710c94" width="220"> 

SignIn Android | SignIn iOS
--- | --- 
<img src="https://github.com/user-attachments/assets/23d52f3c-8340-4584-8c22-2054d1aa6569" width="220"> | <img src="https://github.com/user-attachments/assets/a10424f5-3fc8-47fd-9ed4-921a5c10db17" width="220"> 

SignUp Android | SignUp iOS
--- | --- 
<img src="https://github.com/user-attachments/assets/5f8a80ef-1ebe-44bf-8e4e-747be70783b1" width="220"> | <img src="https://github.com/user-attachments/assets/a87ee345-021e-4931-b477-93b8ecf27ce1" width="220"> 


### Home
Track List, Detail Track and Profile

Home Android | Home iOS
--- | --- 
<img src="https://github.com/user-attachments/assets/394a3b6e-459e-4c37-ac75-8951a2a2f72c" width="220"> | <img src="https://github.com/user-attachments/assets/d6d59654-c48c-4adc-8794-b6b39e89eb3b" width="220"> 


### Room Storage
User and List in Room 

**Tracks table**

<img src="https://github.com/user-attachments/assets/5252e126-41ca-46d7-9116-68d13394692b" width="720"> 

**Users table**

<img src="https://github.com/user-attachments/assets/9bb4e1c2-6807-493e-aae5-cff0c47d6a6e" width="720"> 

## :green_heart: How did you test it?

To test and see movements you can use the following credentials

```
user: speedymovil
password: speedymovil2024
```
You can also create a user from scratch to test Sign Up


**Also you can run the Unit Tests, recommended command:**

```
/gradlew test
```
<img src="https://github.com/user-attachments/assets/01f7a542-1dd7-48fa-bd44-116c5fc8f115" width="720"> 

