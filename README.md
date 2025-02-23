# User Management System

## 📌 Mục tiêu dự án
Xây dựng hệ thống quản lý người dùng với các chức năng:
- Đăng ký, đăng nhập
- Quản lý thông tin người dùng
- Phân quyền người dùng
- Thay đổi mật khẩu
- Xóa tài khoản

## 🛠 Công nghệ sử dụng
- **Backend**: Spring Boot, Spring Security, JPA (Hibernate), MySQL/PostgreSQL
- **Authentication**: JWT hoặc Session-based Authentication
- **Deployment**: Docker, GitHub Actions

## 🚀 Chức năng chính
### 🔹 Authentication & Authorization
- [ ] **Đăng ký tài khoản**
    - Người dùng mới có thể đăng ký với email và mật khẩu
    - Kiểm tra email đã tồn tại chưa
    - Mã hóa mật khẩu bằng **BCrypt**

- [ ] **Đăng nhập**
    - Người dùng có thể đăng nhập bằng email + mật khẩu
    - Trả về **JWT Token** (hoặc thiết lập Session)

- [ ] **Quên mật khẩu**
    - Gửi email chứa link đặt lại mật khẩu
    - Liên kết chỉ có hiệu lực trong **X phút**

- [ ] **Phân quyền người dùng**
    - **Role-Based Access Control (RBAC)**
    - **Admin**: Quản lý user, phân quyền
    - **User**: Chỉ xem và chỉnh sửa thông tin cá nhân

### 🔹 User Management
- [ ] **Danh sách người dùng** (*Chỉ Admin*)
    - Xem danh sách user
    - Tìm kiếm, phân trang

- [ ] **Cập nhật thông tin cá nhân**
    - Người dùng có thể sửa **tên, avatar, số điện thoại**

- [ ] **Thay đổi mật khẩu**
    - Nhập mật khẩu cũ → Nhập mật khẩu mới

- [ ] **Xóa tài khoản**
    - **Admin** có thể xóa user
    - **User** có thể tự xóa tài khoản của mình

## Database - PostgreSQL

## 🎯 Design Patterns Áp Dụng
- **Singleton**: Quản lý các service quan trọng như Authentication, JWT Token Provider.
- **Factory Pattern**: Tạo các đối tượng user với vai trò khác nhau (Admin, User).
- **Repository Pattern**: Tách biệt logic truy vấn dữ liệu với business logic.
- **Strategy Pattern**: Áp dụng cho việc xác thực người dùng qua nhiều phương thức khác nhau (JWT, OAuth2, Session).
- **Observer Pattern**: Dùng để gửi thông báo khi có sự thay đổi quan trọng, ví dụ như gửi email khi đăng ký thành công.

## 🎯 Exception Handler

## 🔐 Security
- [ ] **Mã hóa mật khẩu** với `BCrypt`
- [ ] **JWT Token** cho Authentication
- [ ] **CSRF Protection** nếu dùng Session
- [ ] **CORS Policy** để cho phép frontend truy cập
