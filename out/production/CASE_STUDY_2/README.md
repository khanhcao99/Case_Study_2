## YÊU CẦU TẠO 1 PHẦN MỀM QUẢN LÝ DỮ LIỆU KHÁCH HÀNG CỦA NGÂN HÀNG.
### YÊU CẦU QUẢN LÝ: 
1. Tên
2. Độ tuổi
3. Giới tính
4. Ngày tháng năm sinh
5. Địa chỉ
6. Số điện thoại
7. Email
8. Công việc hiện tại
9. Tiền gửi ngân hàng
10. Các gói hiện đang có:
### - Gói vay:
1. Tên gói vay
2. Số tiền vay
3. Thời hạn
4. Lãi suất

### - Gói gửi tiết kiệm:
1. Tên gói gửi tiết kiệm
2. Số tiền gửi tiết kiệm
3. Thời hạn
4. Lãi suất


## Xây dựng quản lý GÓI VAY:
1. Thêm gói vay mới
2. Chỉnh sửa thông tin gói vay của khách hàng theo tên (Số tiền vay, Lãi suất, Số tháng vay)
3. Chỉnh sửa thông tin gói vay của khách hàng theo id (Số tiền vay, Lãi suất, Số tháng vay) 
4. Xóa gói vay của khách hàng
5. Hiện thị tất cả các gói vay
6. Hiển thị các khách hàng có cùng gói vay
7. Hiển thị các khách hàng sắp phải đáo hạn

## Xây dựng quản lý GÓI TIẾT KIỆM:
1. Thêm gói tiết kiệm mới
2. Chỉnh sửa thông tin gói tiết kiệm của khách hàng theo tên (Số tiền tiết kiệm, Lãi suất, Số tháng tiết kiệm)
3. Chỉnh sửa thông tin gói vay của khách hàng theo id (Số tiền vay, Lãi suất, Số tháng vay)
4. Xóa gói tiết kiệm của khách hàng
5. Hiện thị tất cả các gói tiết kiệm
6. Hiển thị các khách hàng có cùng gói tiết kiệm
7. Hiển thị các khách hàng sắp hết gói tiết kiệm

## Xây dựng quản lý KHÁCH HÀNG:
1. Thêm mới khách hàng(tất cả thuộc tính + gói vay hoặc gói tiết kiệm)
2. Chỉnh sửa thông tin khách hàng theo id(tất cả các thuộc tính, các gói vay hoặc gói tiết kiệm)
3. Xóa thông tin khách hàng
4. Xóa gói vay hoặc gói tiết kiệm của khách hàng
5. Tìm kiếm khách hàng theo tên
6. Tìm kiếm khách hàng theo id
7. Tìm kiếm khách hàng theo GÓI VAY hoặc GÓI TIẾT KIỆM
8. Hiển thị tất cả khách hàng đang quản lý


# UML

## lớp Customer
1. Thuộc tính:
- static ID_CUSTOMER: int
- id: ID_CUSTOMER
- name: String
- age: int
- gender: String
- dayOfbirth: String
- address: String
- phoneNumber: String
- email: String
- work: String
- deposits: int
- loanPackage: LoanPackage
- savingsPackage: SavingsPackage
2. Contructor:
- Customer(): void
- Customer(full): void
3. Getter/Setter
4. toString(): 

## lớp LoanPackage
1. Thuộc tính:
- static ID_LOANPACKAGE: int
- id: ID_LOANPACKAGE
- loanPackageName: String
- loanMoney: int
- period: double
- interestRate: double
2. Contructor:
- LoanPackage()
- LoanPackage(full)
3. Getter/Setter:
4. toString

## lớp SavingPackage
6. Thuộc tính:
- static ID_SAVINGPACKAGE: int
- id: ID_SAVINGPACKAGE
- SavingPackageName: String
- savingMoney: int
- period: double
- interestRate: double
2. Contructor:
- SavingPackage()
- SavingPackage(full)
3. Getter/Setter:
4. toString

## Interface CRUD
- add(E e)
- E getById(int id)
- E getByName(String name)
- E getByLoanPackage(String name)
- E getBySavingPackage(String name)
- updateById(int id) : void
- updateByName(String name): void
