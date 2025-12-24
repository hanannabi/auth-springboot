# Spring Security Authentication & Authorization Architecture

A complete end-to-end security implementation using **Spring Security**, **JWT**, and **Role-Based Access Control (RBAC)**.  
This project demonstrates secure login, token-based authentication, authorization rules, user roles, and protected REST APIs.

---

## Features

### Authentication
- Login with username/password
- JWT token generation
- BCrypt password hashing
- Custom UserDetails & AuthenticationProvider

### Authorization
- Role-Based Access Control (RBAC)
- Access rules using `hasRole()` and `hasAuthority()`
- Method-level security using `@PreAuthorize`

### JWT Security
- Access token generation
- Token validation (signature, expiry)
- Custom JWT filter to validate tokens on every request
- Secure headers & stateless sessions

### Additional Features
- Global Exception Handling for authentication errors
- User registration endpoint
- Secure endpoints for USER/ADMIN
- Clean layered architecture

---

## 🧱 Project Structure

