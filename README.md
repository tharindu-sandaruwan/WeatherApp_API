# 🌦 Weather API - Spring Boot

This project is a secure Spring Boot REST API that provides weather data for a predefined list of cities.  
It leverages **Spring Security** with **Auth0** for authentication and authorization, and implements a caching mechanism to optimize API responses.

---

## ✨ Features

1. **Secure Endpoints** – Uses Spring Security and OAuth 2.0 to protect the `/weather` endpoint.  
2. **Auth0 Integration** – Authenticates users via Auth0, a third-party identity platform.  
3. **External API Integration** – Fetches real-time weather data from the OpenWeatherMap API.  
4. **Response Caching** – Implements a 5-minute cache for weather data to reduce redundant external API calls and improve performance.  
5. **CORS Configuration** – Pre-configured to allow requests from:
   - `http://localhost:5173`
   - `http://localhost:3000`

---

## ⚙️ Configure Environment Variables

This project uses sensitive keys for connecting to Auth0 and OpenWeatherMap.  
It’s best practice to manage these using **environment variables** rather than hardcoding them.

---

### 🔑 Set Up Your Environment Variables

You now need to provide values for the properties defined in `application.properties`.

#### 1. Get Auth0 Credentials
- Log in to your **Auth0 Dashboard**  
- Go to: `Applications → Applications` and select your app (or create a new **"Regular Web Application"**)  
- In the **Settings** tab, you will find:
  - **Client ID**
  - **Client Secret**
  - **Issuer URI** → Your domain with `https://` prefix  
    *(Example: `https://dev-your-tenant.us.auth0.com/`)*

#### 2. Get OpenWeatherMap API Key
- Log in to your **OpenWeatherMap Account**  
- You will find your default API key here  

> 💡 *In this code, that API is not configured in environment variables, So you don't need to add that*

#### 3. Set the Variables
- The easiest way to set these for development is through your IDE's run configuration.
- In IntelliJ IDEA: Go to Run -> Edit Configurations.... In the "Environment variables" field and add them.

#### 4.Configure Auth0 Application URLs
- For the login and logout process to work correctly, you must configure the allowed URLs in your Auth0 Application settings.
- Go to your application's Settings tab in the Auth0 Dashboard.
- Find the Application URIs section.
- Add the following URLs:
     - Allowed Callback URLs: http://localhost:8080/login/oauth2/code/auth0
     - Allowed Logout URLs: http://localhost:8080/

#### 5.Run the Application



