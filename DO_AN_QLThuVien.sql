--------------------------------------------------------------------TẠO DATABASE---------------------------------------------------------------------
use master
go

if exists(select *from sysdatabases where name='QL_KHACHSAN')
drop database QL_KHACHSAN
go


CREATE DATABASE QL_KHACHSAN

ON PRIMARY 
(
	Name=KS_primary,
	filename='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KS_primary.mdf',
	size=5MB,
	maxsize=10MB,
	filegrowth=10%	
),
(
	Name=KS_second1_1,
	filename='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KS_second1_1.ndf',
	size=3MB,
	maxsize=5MB,
	filegrowth=10%	
),
(
	Name=KS_second1_2,
	filename='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KS_second1_2.ndf',
	size=3MB,
	maxsize=5MB,
	filegrowth=10%	
),
(
	Name=KS_second1_3,
	filename='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KS_second1_3.ndf',
	size=3MB,
	maxsize=5MB,
	filegrowth=10%	
)
log on
(
	Name=KS_log,
	filename='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KS_log.ldf',
	size=1MB,
	maxsize=5MB,
	filegrowth=15%	
)
go
go



USE QL_KHACHSAN
GO
---------------------------------------------------------------TẠO BẢNG,KHOÁ CHÍNH,KHOÁ NGOẠI--------------------------------------------------------


------ TẠO BẢNG TAIKHOAN
CREATE TABLE QUANTRI
(
	ID int IDENTITY(1,1) PRIMARY KEY,
	TENTK VARCHAR(20) ,
	MATKHAU VARCHAR(200)
)


------ TẠO BẢNG LOẠI PHÒNG 

CREATE TABLE LOAIPHONG
(
MaLoai char(20) primary key,
TenLoai nvarchar(50)


)
GO


------ TẠO BẢNG PHÒNG 

CREATE TABLE PHONG
(
MaPhong char(20) primary key,
TenPhong nvarchar(50),
MaLoai char(20),
TinhTrang bit, --1 la phong co khach---0 la phong trong
GiaPhong float,
constraint fk_phong_loai foreign key (MaLoai) references LOAIPHONG(MaLoai)
)
GO

------ TẠO BẢNG NHÂN VIÊN 

CREATE TABLE NHANVIEN
(
MaNV char(20)primary key,
MATKHAU VARCHAR(200) NOT NULL,
HoTen nvarchar(50),
GioiTinh nvarchar(5),
NgaySinh date,
SoDT char(12)
)

GO
------ TẠO BẢNG KHACH HANG 

CREATE TABLE KHACHHANG
(
MaKH char(20)primary key,
TenKH nvarchar(50),
GioiTinh nvarchar(5),

DiaChi nvarchar(100),
SoDT char(12)
)
GO
------ TẠO BẢNG DỊCH VỤ 
CREATE TABLE DICHVU 
(
MaDV char(20)primary key,
TenDV nvarchar(50),
GiaDV float

)

------ TẠO BẢNG THUÊ PHÒNG 

CREATE TABLE THUEPHONG
(
MaThue char(20),
MaKH char(20),
MaPhong char(20),
NgayVao date,
NgayRa date,
tienThue float,
constraint pk_thuephong primary key(MaThue),
constraint fk_TP_khach foreign key(MaKH) references KHACHHANG(MaKH),
constraint fk_TP_Phong foreign key(MaPhong) references PHONG(MaPhong)
)

GO
------ TẠO BẢNG SỬ DỤNG DỊCH VỤ 

CREATE TABLE SDDICHVU
(
MaSD char(20)primary key,
MaThue char(20),
MaDV char(20),
SoLuong int,
TienSD float,
constraint fk_SDV_thue foreign key(MaThue) references THUEPHONG(MaThue),
constraint fk_SDV_DV foreign key(MaDV) references DICHVU(MaDV)
)
GO
------ TẠO BẢNG THANH TOÁN 

CREATE TABLE THANHTOAN
(
MaThue char(20)primary key,
ThanhTien float,
NgayTToan date,
constraint fk_tt_thue foreign key(MaThue) references THUEPHONG(MaThue)
)
Go

SET DATEFORMAT DMY
-------------------------------------------------------------TẠO RÀNG BUỘC TOÀN VẸN------------------------------------------------------------------
-----------------BẢNG LOẠI PHÒNG 

-----------------BẢNG PHÒNG 


--------GIA PHONG PHAI LON HON 0 
ALTER TABLE PHONG ADD CONSTRAINT CHK_GIAPHONG  CHECK( GiaPhong >0)

----TÊN PHONG  LÀ DUY NHẤT
ALTER TABLE PHONG  ADD CONSTRAINT UNI_TENPHONG  UNIQUE(TenPhong)

----TÌNH TRẠNG MẶC ĐỊNH LÀ 0
ALTER TABLE PHONG  ADD CONSTRAINT DF_TINHTRANGP DEFAULT 0 FOR TinhTrang 

-----------------BẢNG NHÂN VIÊN 
SELECT*FROM NHANVIEN

----GIỚI TÍNH THUỘC NAM HOẶC NỮ
ALTER TABLE NHANVIEN ADD CONSTRAINT CHK_GIOITINH_NV CHECK(GIOITINH IN(N'Nam',N'Nữ'))


----------------- BẢNG KHACH HANG 



----GIỚI TÍNH THUỘC NAM HOẶC NỮ
ALTER TABLE KHACHHANG ADD CONSTRAINT CHK_GIOITINH_KH CHECK(GIOITINH IN(N'Nam',N'Nữ'))


----------------- BẢNG DỊCH VỤ 


------TÊN DICH VU  PHẢI DUY NHẤT
ALTER TABLE DICHVU  ADD CONSTRAINT UNI_TENDV  UNIQUE(TenDV)
------GIA DICH VU  PHẢI LỚN HƠN 0
ALTER TABLE DICHVU  ADD CONSTRAINT CHK_GIA_DV  CHECK(GiaDV>0)

-----------------BẢNG THUÊ PHÒNG 

---tien thue hpng phai lon hon 0
ALTER TABLE THUEPHONG  ADD CONSTRAINT CHK_tienthue  CHECK(tienThue>0)

--NGAY VAO PHAI  NHO HON HOAC BANG  NGAY RA 
ALTER TABLE THUEPHONG ADD CONSTRAINT check_NGAYTHUE   CHECK (NgayVao <= NgayRa)

----------------- BẢNG SỬ DỤNG DỊCH VỤ 


------Tong tien su dung dich vu  PHẢI LỚN HƠN 0
ALTER TABLE SDDICHVU   ADD CONSTRAINT CHK_TongTienSD  CHECK(TienSD  >0)

------  so luong   PHẢI LỚN HƠN 0
ALTER TABLE SDDICHVU   ADD CONSTRAINT CHK_soluong   CHECK(SoLuong>0)
go
------------------------------------------------------------INSERT DỮ LIỆU---------------------------------------------------------------------------


insert into QUANTRI values('admin','21232f297a57a5a743894a0e4a801fc3');
----BẢNG QUẢN TRỊ
set dateformat dmy
------ TẠO BẢNG LOẠI PHÒNG 

INSERT INTO LOAIPHONG  VALUES('LP001',N'PHÒNG VIP');
INSERT INTO LOAIPHONG  VALUES('LP002',N'PHÒNG THƯỜNG');
INSERT INTO LOAIPHONG  VALUES('LP003',N'PHÒNG 2 GIƯỜNG');
INSERT INTO LOAIPHONG  VALUES('LP004',N'PHÒNG 3 GIƯỜNG');
INSERT INTO LOAIPHONG  VALUES('LP005',N'PHÒNG 4 GIƯỜNG');
GO

------ TẠO BẢNG PHÒNG 

INSERT INTO PHONG VALUES('MP001',N'PHÒNG A','LP001',0,800);
INSERT INTO PHONG VALUES('MP002',N'PHÒNG B','LP001',0,800);
INSERT INTO PHONG VALUES('MP003',N'PHÒNG C','LP002',0,200);
INSERT INTO PHONG VALUES('MP004',N'PHÒNG D','LP005',0,600);
INSERT INTO PHONG VALUES('MP005',N'PHÒNG E','LP002',0,200);
INSERT INTO PHONG VALUES('MP006',N'PHÒNG F','LP003',0,350);
INSERT INTO PHONG VALUES('MP007',N'PHÒNG G','LP004',0,450);
INSERT INTO PHONG VALUES('MP008',N'PHÒNG H','LP001',0,800);
GO

select*from NHANVIEN
------ TẠO BẢNG NHÂN VIÊN 

INSERT INTO NHANVIEN VALUES('NV001','202cb962ac59075b964b07152d234b70',N'Dương Đông Duy',N'Nam','06/12/2001','0376880903');
INSERT INTO NHANVIEN VALUES('NV002','202cb962ac59075b964b07152d234b70',N'Hồ Đức Duy',N'Nam','01/11/2000','0348770100');
INSERT INTO NHANVIEN VALUES('NV003','202cb962ac59075b964b07152d234b70',N'VŨ THỊ THANH DANH',N'Nữ', '04/05/1999','0473526483');
INSERT INTO NHANVIEN VALUES('NV004','202cb962ac59075b964b07152d234b70',N'Võ Thị Thu Hà ',N'Nữ','10/03/2001','0328090646');
INSERT INTO NHANVIEN VALUES('NV005','202cb962ac59075b964b07152d234b70',N'Điêu Ngoc Trinh ',N'Nữ','06/11/2001','0376880000');
INSERT INTO NHANVIEN VALUES('NV006','202cb962ac59075b964b07152d234b70',N'VŨ THỊ THANH DANH',N'Nữ', '04/05/1999','0473526483');
INSERT INTO NHANVIEN VALUES('NV007','202cb962ac59075b964b07152d234b70',N'Nguyễn Thị Thảo Vy ',N'Nữ ','03/02/2001','0353676482');
INSERT INTO NHANVIEN VALUES('NV008','202cb962ac59075b964b07152d234b70',N'Ngô Thanh Huyền ',N'Nữ ','10/03/2001','0583527543');
INSERT INTO NHANVIEN VALUES('NV09', '202cb962ac59075b964b07152d234b70',N'VŨ THỊ THANH DANH',N'Nữ', '04/05/1999','0473526483');
INSERT INTO NHANVIEN VALUES('NV010','202cb962ac59075b964b07152d234b70',N'LÊ XUÂN BẮC',N'Nam','05/06/2001','0376880400');
INSERT INTO NHANVIEN VALUES('NV011','202cb962ac59075b964b07152d234b70',N'TRẦN TUẤN ANH',	N'Nam','07/12/2000','0487362873');
INSERT INTO NHANVIEN VALUES('NV012','202cb962ac59075b964b07152d234b70',N'VŨ THỊ THANH DANH',N'Nữ', '04/05/1999','0473526483');
INSERT INTO NHANVIEN VALUES('NV013','202cb962ac59075b964b07152d234b70',N'LƯU THANH BÌNH',	N'Nam','28/02/1999','0387529267');
INSERT INTO NHANVIEN VALUES('NV014','202cb962ac59075b964b07152d234b70',N'VŨ THỊ THANH DANH',N'Nữ', '04/05/1999','0473526483');
go

------ TẠO BẢNG KHACH HANG 

INSERT INTO KHACHHANG VALUES('KH01',N'NGUYỄN HẢI ĐĂNG',N'Nam',N'TP.HCM','0364767243');
INSERT INTO KHACHHANG VALUES('KH02',N'HOÀNG TIẾN ĐẠT',N'Nam',N'CẦN THƠ','0463745625');
INSERT INTO KHACHHANG VALUES('KH03',N'TRỊNH DUY ĐÔNG',N'Nam',N'AN GIANG','0975645370');
INSERT INTO KHACHHANG VALUES('KH04',N'VÕ THUỲ DƯƠNG',N'Nữ',N'LONG AN','0976352638');
INSERT INTO KHACHHANG VALUES('KH05',N'NGUYỄN THỊ HẠNH DUYÊN',N'Nữ',N'TP.HCM','0945324538');
INSERT INTO KHACHHANG VALUES('KH06',N'NGUYỄN NHẬT HÀO',N'Nam',N'TP.HCM','0463725379');
INSERT INTO KHACHHANG VALUES('KH07',N'TRƯƠNG THỊ HOA',N'Nữ',N'TP.HCM','0403647365');
INSERT INTO KHACHHANG VALUES('KH08',N'TRẦN THỊ THUÝ HOÀ',N'Nữ',N'TP.HCM','0402045342');
INSERT INTO KHACHHANG VALUES('KH09',N'TRẦN THỊ KIỀU OANH',N'Nữ',N'TP.HCM','0286534271');
INSERT INTO KHACHHANG VALUES('KH10',N'TRẦN THỊ THU HỒNG',N'Nữ',N'TP.HCM','04837523527');
INSERT INTO KHACHHANG VALUES('KH11',N'NGUYỄN THỊ HỒNG',N'Nữ',N'TP.HCM','0354828423');
INSERT INTO KHACHHANG VALUES('KH12',N'ĐỖ THỊ NGỌC HƯƠNG ',N'Nữ',N'TP.HCM','0835427287');
INSERT INTO KHACHHANG VALUES('KH13',N'LÊ THANH TUẤN KIỆT',N'Nam',N'TP.HCM','09876543212');
INSERT INTO KHACHHANG VALUES('KH14',N'MAI ĐỨC KIỀU',N'Nam',N'TP.HCM','0925362438');
INSERT INTO KHACHHANG VALUES('KH15',N'HUỲNH TRỌNG HIỂN',N'Nam',N'TIỀN GIANG','0987678678');
INSERT INTO KHACHHANG VALUES('KH16',N'NGUYỄN MINH NHỰT',N'Nam',N'VĨNH LONG','0876563211');
INSERT INTO KHACHHANG VALUES('KH17',N'NGUYỄN THẢO HƯƠNG QUỲNH',N'Nữ',N'KIÊN GIANG','0376880903');
INSERT INTO KHACHHANG VALUES('KH18',N'NGUYỄN TRẦN HOÀ HỢP',N'Nữ',N'BẾN TRE','0988322241');
INSERT INTO KHACHHANG VALUES('KH19',N'LÊ HIẾU NGHĨA',N'Nam',N'BẾN TRE','0878493212');
INSERT INTO KHACHHANG VALUES('KH20',N'NGUYỄN MINH ĐỨC',N'Nam',N'CÀ MAU','0987771232');

------ TẠO BẢNG DỊCH VỤ 

 INSERT INTO DICHVU  Values('DV01', N'Quầy bar', 100);
 INSERT INTO DICHVU  Values ('DV02', N'Café', 12);
 INSERT INTO DICHVU  Values ('DV03', N'Spa', 100);
 INSERT INTO DICHVU  Values ('DV04', N'Phòng họp', 120);
 INSERT INTO DICHVU  Values ('DV05', N'Giặt ủi', 20);
 INSERT INTO DICHVU  Values ('DV06', N'Dịch vụ 24/24', 200);
 INSERT INTO DICHVU  Values ('DV07', N'Fitness centre', 10);

GO

------ TẠO BẢNG THUÊ PHÒNG

INSERT INTO THUEPHONG VALUES('MT01','KH09','MP001', '14/06/2020' ,'15/06/2020',null );
INSERT INTO THUEPHONG VALUES('MT02','KH08','MP005', '10/12/2019' ,'13/12/2019',null  );
INSERT INTO THUEPHONG VALUES('MT03','KH07','MP002', '9/03/2021' ,'12/03/2021',null  );
INSERT INTO THUEPHONG VALUES('MT04','KH06','MP004', '03/07/2021' ,'04/07/2021',null  );
INSERT INTO THUEPHONG VALUES('MT05','KH05','MP003', '05/12/2019' ,'12/12/2019',null  );
INSERT INTO THUEPHONG VALUES('MT06','KH04','MP003', '08/06/2020', '11/06/2020',null );
INSERT INTO THUEPHONG VALUES('MT07','KH03','MP007', '15/03/2019' ,'20/03/2019',null  );
INSERT INTO THUEPHONG VALUES('MT08','KH02','MP006', '20/09/2021' ,'28/09/2021',null  );
INSERT INTO THUEPHONG VALUES('MT09','KH01','MP008', '23/12/2021' ,'25/12/2021',null  );

GO 

------ TẠO BẢNG SỬ DỤNG DỊCH VỤ 

INSERT INTO SDDICHVU VALUES('MSD01','MT02','DV02',1 ,null);
INSERT INTO SDDICHVU VALUES('MSD02','MT01','DV01',4 ,null);
INSERT INTO SDDICHVU VALUES('MSD03','MT07','DV03',2 ,null);
INSERT INTO SDDICHVU VALUES('MSD04','MT05','DV04',1 ,null);
INSERT INTO SDDICHVU VALUES('MSD05','MT06','DV07',5 ,null);
INSERT INTO SDDICHVU VALUES('MSD06','MT03','DV06',2 ,null);
INSERT INTO SDDICHVU VALUES('MSD07','MT09','DV05',3 ,null);
GO

------ TẠO BẢNG THANH TOÁN 

INSERT INTO THANHTOAN VALUES('MT02',NULL ,GETDATE());
INSERT INTO THANHTOAN VALUES('MT03',NULL ,GETDATE());
INSERT INTO THANHTOAN VALUES('MT04',NULL ,GETDATE());
INSERT INTO THANHTOAN VALUES('MT05',NULL ,GETDATE());
INSERT INTO THANHTOAN VALUES('MT06',NULL ,GETDATE());
INSERT INTO THANHTOAN VALUES('MT07',NULL ,GETDATE());
INSERT INTO THANHTOAN VALUES('MT08',NULL ,GETDATE());
INSERT INTO THANHTOAN VALUES('MT09',NULL ,GETDATE());
GO 

--1.CẬP NHẬT TIỀN SỬ DỤNG DỊCH VỤ CHO BẢNG SDDICHVU:TienSD=SỐ LƯỢNG DỊCH VỤ *GIÁ DỊCH VỤ 

update SDDICHVU
set TienSD=SoLuong*(select dv.GiaDV  from DICHVU dv where dv.MaDV=SDDICHVU.MaDV )

select*from SDDICHVU

-----2 .CẬP NHẬT TIỀN THUE PHÒNG CO BẢNG THUEPHONG :TIENTHUE=SỐ NGÀY Ở * GIÁ PHÒNG


update THUEPHONG
set tienThue=(SELECT  (DATEDIFF(DD,NgayVao,NgayRa) *p.GiaPhong )  from PHONG p where THUEPHONG.MaPhong=p.MaPhong)


select*from THUEPHONG

--3.CẬP NHẬT THANHTOAN CHO BẢNG THANHTOAN :thanhtien=tien thue phong +tien su dung dich vu 

UPDATE THANHTOAN

SET ThanhTien = (select tp.tienThue*sd.TienSD   from THUEPHONG tp,SDDICHVU sd where tp.MaThue=THANHTOAN.MaThue and sd.MaThue=THANHTOAN.MaThue)

select*from THANHTOAN

---------------------------------------------------------------------------------------------thao tac voi data ---------------------------------------------

--------------lệnh nhập  data từ file .txt vao SQL-------------------

	Bulk insert		[dbo].[LoaiPhong]
	from 'D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\SQL.txt'
	with (
		
	DATAFILETYPE='char',
	FIELDTERMINATOR=' ',--phan ngan cah giua cac truong neu ',' thif minh thuc hien tt 
	ROWTERMINATOR='\n',---phan ket thuc mot dong ,
	FIRSTROW =1
	)

	go
---------------------------------------------------------------------------------Enable xp_cmdshell
-- To allow advanced options to be changed.  
---Để cho phép các tùy chọn  được thay đổi.
EXECUTE sp_configure 'show advanced options', 1;  
GO  
-- To update the currently configured value for advanced options.  
-----Để cập nhật giá trị hiện được cấu hình
RECONFIGURE;  
GO  
-- To enable the feature.  
---Để kích hoạt tính năng.
EXECUTE sp_configure 'xp_cmdshell', 1;  
GO  
-- To update the currently configured value for this feature.  
---Để cập nhật giá trị hiện được định cấu hình cho tính năng này.
RECONFIGURE;  
GO 
---------------------------------------------------------------------------------Xuat tu SQL BANG pcb-----------------------------------------------

------------bang DICHVU
declare @SQL varchar(500) = ''
set @sql = 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].DICHVU"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\DICHVU_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL
-------------------bang khach hang 
declare @SQL1 varchar(500) = ''
set @sql1 = 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].KHACHHANG"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KHACHHANG_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL1
--------------bang LOAIPHONG
declare @SQL3 varchar(500) = ''
set @sql3 = 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].LOAIPHONG"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\LOAIPHONG_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL3
-----------bang NHANVIEN
declare @SQL2 varchar(500) = ''
set @sql2 = 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].NHANVIEN"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\NHANVIEN_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL2
-------------------bangPHONG 
declare @SQL4 varchar(500) = ''
set @sql4 = 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].PHONG"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\PHONG_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL4
----------bang SDDICHVU 
declare @SQL5 varchar(500) = ''
set @sql5 = 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].SDDICHVU"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\SDDICHVU_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL5
----------bang THANHTOAN
declare @SQL6 varchar(500) = ''
set @sql6 = 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].THANHTOAN"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\THANHTOAN_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL6
----------bang THUEPHONG 
declare @SQL7 varchar(500) = ''
set @sql7= 'bcp " SELECT * FROM [QL_KHACHSAN].[dbo].THUEPHONG"queryout"D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\THUEPHONG_SQL.txt" -w -T -t, -S ACER-THUHA -U sa -P 1003'
exec master..xp_cmdshell @SQL7


------------------------------------------------------------------------------CÁC CÂU TRUY VẤN DỮ LIỆU------------------------------------------------------------

--1.CẬP NHẬT TIỀN SỬ DỤNG DỊCH VỤ CHO BẢNG SDDICHVU:TienSD=SỐ LƯỢNG DỊCH VỤ *GIÁ DỊCH VỤ 
update SDDICHVU
set TienSD=SoLuong*(select dv.GiaDV  from DICHVU dv where dv.MaDV=SDDICHVU.MaDV )

select*from SDDICHVU
go
-----2 .CẬP NHẬT TIỀN THUE PHÒNG CO BẢNG THUEPHONG :TIENTHUE=SỐ NGÀY Ở * GIÁ PHÒNG
update THUEPHONG
set tienThue=(SELECT  (DATEDIFF(DD,NgayVao,NgayRa) *p.GiaPhong )  from PHONG p where THUEPHONG.MaPhong=p.MaPhong)


select*from THUEPHONG
go
--3.CẬP NHẬT THANHTOAN CHO BẢNG THANHTOAN :thanhtien=tien thue phong +tien su dung dich vu 
UPDATE THANHTOAN

SET ThanhTien = (select tp.tienThue*sd.TienSD   from THUEPHONG tp,SDDICHVU sd where tp.MaThue=THANHTOAN.MaThue and sd.MaThue=THANHTOAN.MaThue)
select*from THANHTOAN
go

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

----4:. XUẤT RA DANH SÁCH NHÂN VIÊN Nam Họ Dương  .THÔNG TIN BAO GỒM:MANV,TENNV,NGAYSINH,SDT
SELECT MaNV,HoTen,NgaySinh,SoDT  from NHANVIEN
where HoTen like N'Dương%' and GioiTinh=N'Nam' 

SELECT*FROM NHANVIEN
go
----5.IN RA DANH SÁCH KHÁCH HÀNG Ở TP HCM .THÔNG TIN BAO GỒM:MAKH,TENKH,GIOITINH,TENPHONG 
SELECT KH.MaKH,TenKH,GioiTinh,P.TenPhong  FROM PHONG P,THUEPHONG TP,KHACHHANG KH
WHERE P.MaPhong=TP.MaPhong AND TP.MaKH=KH.MaKH AND KH.DiaChi=N'TP.HCM'

select*from KHACHHANG
SELECT*FROM PHONG
SELECT*FROM THUEPHONG
go
--6.XUẤT RA THÔNG TIN NHÂN VIÊN  SẮP XẾP TĂNG DẦN THEO NGAY SINH 
SELECT* FROM NHANVIEN
ORDER BY NgaySinh ASC

SELECT*FROM NHANVIEN
go
--7.ĐẾM SỐ LƯỢNG NHÂN VIÊN NAM VÀ SỐ LƯỢNG NHÂN VIÊN NỮ.
SELECT 'NHÂN VIÊN NAM'=SUM(CASE WHEN GioiTinh=N'Nam' THEN 1 ELSE 0 END),'NHÂN VIÊN NỮ'=SUM(CASE WHEN GIOITINH=N'Nữ ' THEN 1 ELSE 0 END) 
FROM NHANVIEN

SELECT*FROM NHANVIEN
go
--8.CHO BIET SO NGAY THUE PHONG .THÔNG TIN BAO GỒM: MATHUEP,TENKHACH,MAPHONG,TIENTHUE
SELECT TP.MaThue,TP.MaPhong,TP.tienThue ,KH.TenKH,(DATEDIFF(DD,NgayVao,NgayRa)) AS 'SỐ NGÀY THUÊ ' FROM THUEPHONG TP,KHACHHANG KH
WHERE TP.MaKH=KH.MaKH


select*from THUEPHONG
SELECT*FROM KHACHHANG
GO

------------------------------------------------------------------truy vấn có sử dụng khai báo biến, cấu trúc if else, case, vòng lặp while.---------------------------------------------
---1.xuat ra ma khach hang co so tien thanh toan cao nhat
Declare @maxtt int
declare @makh char(20)

select @maxtt=max(tienThue) from THUEPHONG tp,THANHTOAN tt where tp.MaThue=tt.MaThue
select @makh= tp.MaKH from THUEPHONG tp,THANHTOAN tt where tp.MaThue=tt.MaThue and tienThue=@maxtt

print @makh


select*from THUEPHONG
select*from THANHTOAN
go
---2.dem so luong khach co ma KH02 co thue phong 
declare @makh char(20) ='KH03'
select count(*) as slkhthue from KHACHHANG kh where exists (select * from THUEPHONG tp where tp.MaKH=kh.MaKH and tp.MaKH=@makh)

select*from KHACHHANG
select*from THUEPHONG
go
---3.cho biet gia dich vu va in ra ten dich vu tuong ung 
declare @gia float=100

if(@gia=12)
	PRINT N'Café'
ELSE
if(@gia=100)
		begin
		print N'Quầy bar'
		print N'Spa'
		end
	else
	if(@gia=120)
		print N'Phòng họp'
	else
	if(@gia=20)
		print N'Giặt ủi'
	else
	if(@gia=200)
		begin
		print N'Dịch vụ 24/24'
		print N'Giặt ủi 12'

		end
	else
		print N'ko co ten dich vu nay'

select * from DICHVU

go
---4.Cho biet ho   tên nhân viên,gioi tinh ,nhân viên sinh vao  thứ mấy trong tuần,ngay sinh.
---weekday, dw, w	:Ngày trong tuần
 SELECT HoTen,GioiTinh,
 CASE DATENAME(DW,NgaySinh)
				WHEN 'Monday' THEN N'THỨ 2'
				WHEN 'Tuesday' THEN N'THỨ 3'
				WHEN 'Wednesday' THEN N'THỨ 4'
				WHEN 'Thursday' THEN N'THỨ 5'
				WHEN 'Friday' THEN N'THỨ 6'
				WHEN 'Saturday' THEN N'THỨ 7'
				ELSE N'CHỦ NHẬT'
				END 'THỨ',NgaySinh
	
FROM NHANVIEN 

---5:
--while

--begin
--end
go
-----------------------------------------------------------------------------------CÁC THỦ TỤC(STORE PROCEDURE)-----------------------------------------------------------


----1 Tạo thủ tục TIMNV in ra thông tin của sinh viên có MaNV do người dùng truyền vào.

CREATE PROC SP_TIMNV @MaNV CHAR(20)

AS
begin
	SELECT HoTen,GioiTinh,NgaySinh,SoDT

	FROM NHANVIEN

	WHERE MaNV= @MaNV
end

EXEC SP_TIMNV 'NV002'

DROP PROC SP_TIMNV

go
---2.Viết thủ tục truyền vào makh xuất tenk,diachi .
---Nếu không có khách hàng in ra câu thông báo 'khách hàng không tồn tại'
CREATE PROC SP_TTKHACH
@MAKH CHAR(20)
AS

BEGIN
	IF NOT EXISTS(SELECT*FROM KHACHHANG WHERE MaKH=@MAKH)
	PRINT N'KHÁCH HÀNG KHÔNG TỒN TẠI'
	ELSE
	SELECT TenKH,DiaChi FROM KHACHHANG  WHERE MaKH=@MAKH
END

------GOI THU TUC  DUNG:
EXEC SP_TTKHACH 'KH03'               
-------GOI THU TUC SAI:
EXEC SP_TTKHACH 'KH00'               
----XOA HAM:
DROP PROC SP_TTKHACH

SELECT*FROM KHACHHANG
GO
---3.Viết thủ tục truyền MATHUEPGHONG ,NGAYTHUEPHONG xuất ra MAKHACH,TENKHACH,TIENTHUEPHONG.Nếu không có thông báo không tìm thấy
CREATE PROC SP_TTTHUEP
@MATHUEP CHAR(20),@NGAYTHUE DATE
AS
BEGIN
	IF NOT EXISTS(SELECT*FROM THUEPHONG TP,KHACHHANG KH WHERE TP.MaKH=KH.MaKH AND MaThue=@MATHUEP AND NgayVao=@NGAYTHUE)
	PRINT N'KHÔNG TÌM THẤY'
	ELSE
	SELECT TP.MaKH,KH.TenKH,tienThue FROM THUEPHONG TP,KHACHHANG KH WHERE TP.MaKH=KH.MaKH AND MaThue=@MATHUEP AND NgayVao=@NGAYTHUE

END

------GOI THU TUC  DUNG:

EXEC SP_TTTHUEP 'MT01' , '2020-06-14'             

-------GOI THU TUC SAI:
EXEC SP_TTTHUEP 'KH00' ,'2021-03-09'             
----XOA HAM:
DROP PROC SP_TTTHUEP

SELECT*FROM THUEPHONG
GO
---4.Viết thủ tục xuất ra tên DICHVU và số lượng SDDICHVU(số lượng từ 3 trở lên) .
CREATE PROC SP_XUATTT
AS
BEGIN
	SELECT DV.TenDV,SD.SoLuong FROM DICHVU DV,SDDICHVU SD
	WHERE DV.MaDV=SD.MaDV AND SoLuong>2

END
GO
----GOI THU TUC :
EXEC SP_XUATTT

DROP PROC SP_XUATTT
GO

-----5.in ra danh sach nhan vien
create proc SP_nhanvien
as select*from NHANVIEN
go

exec SP_nhanvien
go

drop proc SP_nhanvien
go
----6:Tạo thủ tục cho biết tien thue phong của một nhan vien
CREATE PROC SP_XEMTIENTHUE @MaKH CHAR(20),
@MaThue CHAR(20), @tienThue float OUTPUT

AS
begin
	SET @tienThue = (SELECT tp.tienThue FROM THUEPHONG tp,KHACHHANG kh

			WHERE tp.MaThue= @MaThue AND kh.MaKH = @MaKH
			)

end
go
-- Gọi thực thi thủ tục

DECLARE @tienThue float ,@makh char(20)='KH08',@math char(20)='MT02'
EXEC SP_XEMTIENTHUE @makh,@math, @tienThue output
PRINT 'Tien thue cua khach  '+CONVERT(char(5), @makh)+'la: ' +CONVERT(char(5),@tienThue)

drop proc SP_XEMTIENTHUE

select*from  KHACHHANG
select*from THUEPHONG
go
----7:Tạo thủ tục trả về tuổi của một nhan vien

CREATE PROC SP_tinhtuoi @manv char(20),
						@tuoi int OUTPUT

AS
begin
		SET @tuoi = (SELECT datediff(yy, NgaySinh, getdate())
		FROM NHANVIEN WHERE MaNV = @manv)
end

go
------------Gọi thực hiện ------------
DECLARE @tuoinv int,@manv char(20)='NV004'             
EXEC SP_tinhtuoi @manv, @tuoinv OUTPUT
PRINT 'Tuoi cua nhan vien '+convert(char(5),@manv)+' la: '+convert(char(5),@tuoinv)

drop proc SP_tinhtuoi

select*from NHANVIEN
go
------------------------------------------------------------------------------------------CÁC HÀM (FUNCTION)--------------------------------------------------------------------

----1..Viet ham cho biet  ten nhan vien khi truyen vao ma nhan vien
create    function UF_SLTenNV (@maNV char(20))
returns nvarchar(50)
as
	begin
	declare @tenNV nvarchar(50)
	select @tenNV =HoTen from NHANVIEN where MaNV=@maNV
	return @tenNV

	end
GO
----goi ham thuc thi
select dbo.UF_SLTenNV(MaNV) from NHANVIEN
---xoa ham
drop function dbo.UF_SLTenNV
go
----2.Viet ham xem danh sach sinh vien
create function UF_DSSINHVIEN()
returns table
as
return select*from NHANVIEN
go
---goi ham
select * from  UF_DSSINHVIEN()
---xoa ham
drop function UF_DSSINHVIEN
go
----3.Dua vao tuoi cua nhan vien hien chan hay le
create function UF_Tuoi(@i int)
returns nvarchar(10)
as
	begin
	if(@i%2=0)
	return N'So Chan'
	else
	return N'So Le'
	return N'Ko xac dinh'
end
go
-----select dbo.UF_Tuoi(4)
create function UF_TT(@nam date)
returns int
as
	begin
	return year(getdate())-year(@nam)
	end
go
---goi ham chay:
select dbo.UF_TT(NgaySinh) ,dbo.UF_Tuoi(dbo.UF_TT(NgaySinh))   from NHANVIEN
---xoa ham
drop function UF_Tuoi 
drop function UF_TT
go
----4.nhập vào tên của NHÂN VIÊN VÀ CHO BIẾT TUÔI CỦA Nhan vien ĐÓ
CREATE FUNCTION UF_TTUOI (@TEN NVARCHAR(20))
RETURNS INT
AS
	BEGIN
	DECLARE @TUOI INT
	SELECT @TUOI=DATEDIFF(YYYY,NgaySinh,GETDATE())
	FROM NHANVIEN
	WHERE HoTen=@TEN
	RETURN @TUOI

	END


GO
---goi ham thuc thi
SELECT dbo.UF_TTUOI(N'Dương Đông Duy') as TuoiNV
---xoa ham
drop function dbo.UF_TTUOI

SELECT*FROM NHANVIEN
go

---5.Viết hàm truyền vào manv in ra tên nhân viên,nhân viên SINH VAO  thứ mấy trong tuần,NgáySinh.

create  FUNCTION UF_XemTuoi(@MANV CHAR(20))
RETURNS TABLE
AS
RETURN SELECT HoTen,GioiTinh,CASE DATENAME(DW,NgaySinh) WHEN 'Monday' THEN N'THỨ 2'
											 WHEN 'Tuesday' THEN N'THỨ 3'
											 WHEN 'Wednesday' THEN N'THỨ 4'
											 WHEN 'Thursday' THEN N'THỨ 5'
											 WHEN 'Friday' THEN N'THỨ 6'
											 WHEN 'Saturday' THEN N'THỨ 7'
											 ELSE N'CHỦ NHẬT'
											 END 'Sinh Vao THỨ',NgaySinh 
							FROM NHANVIEN WHERE MaNV=@MANV

go
---goi ham thuc thi
SELECT *FROM  DBO.UF_XemTuoi('NV005')
---xoa ham 
drop FUNCTION DBO.UF_XemTuoi

select*from NHANVIEN
go

----6;Thong ke so luong khach hang khi truyen vaoi ma khach

CREATE FUNCTION UF_TongKH(@MaKH char(20))
RETURNS @bangthongke TABLE(
						MaKH char(20),
						TenKH NVARCHAR(50),
						GioiTinh NVARCHAR(5),
						DiaChi nvarchar(50),
						TongKH INT
						)
AS
	BEGIN
		IF @MaKH = 'KH01'
			
			INSERT INTO @bangthongke

			SELECT MaKH, TenKH,GioiTinh, DiaChi,Count(MaKH)
			FROM KHACHHANG
			WHERE KHACHHANG.MaKH=@MaKH

			GROUP BY MaKH, TenKH,GioiTinh, DiaChi

			RETURN
	END
go
----goi ham Câu lệnh:

SELECT * FROM dbo.UF_TongKH('KH01')

---xoa ham

drop function dbo.UF_TongKH
go

-------------------------------------------------------------------------CÁC TRIGGER---------------------------------------------------------------------------
---1 Viết trigger kiểm tra phái của nhan vien khi nhap vao  là Nam hoặc Nữ
CREATE TRIGGER TRG_CAUB ON NHANVIEN
FOR INSERT,UPDATE
AS
BEGIN
	IF((SELECT GioiTinh FROM inserted) NOT IN ('NAM',N'NỮ'))
	BEGIN
	PRINT N'PHÁI PHẢI LÀ NAM HOẶC NỮ'
	ROLLBACK TRAN
	END
END
go
------insert dung:
INSERT INTO NHANVIEN VALUES('NV019','202cb962ac59075b964b07152d234b70',N'VŨ THỊ THANH DANH11',N'Nữ', '04/05/1999','0473526483');
----insert sai:
INSERT INTO NHANVIEN VALUES('NV020','202cb962ac59075b964b07152d234b70',N'VŨ THỊ THANH DANH12',N'BD', '04/05/1999','0473526483');

SELECT *FROM NHANVIEN
----xoa trigger
drop trigger TRG_CAUB
go
---2.Viết trigger không nhận nhân viên dưới 18 tuổi.(Khi thêm dữ liệu vào bảng NHANVIEN)
CREATE TRIGGER TRG_THEMNV ON NHANVIEN
FOR INSERT
AS
BEGIN
	DECLARE @TUOI INT
	SELECT @TUOI=DATEDIFF(YY,NgaySinh,GETDATE()) FROM inserted
	IF(@TUOI<18)
	BEGIN
	PRINT N'KHÔNG NHẬN NHÂN VIÊN DƯỚI 18 TUỔI'
	ROLLBACK TRAN
	END
END
go
----INSERT NHAN VIEN DUNG:
SET DATEFORMAT DMY

INSERT INTO NHANVIEN VALUES('NV018','202cb962ac59075b964b07152d234b70',N'Dương Duy',N'Nam', '06/12/2000','0473526483');
----INSERT NHAN VIEN SAI:
SET DATEFORMAT DMY

INSERT INTO NHANVIEN VALUES('NV017','202cb962ac59075b964b07152d234b70',N'Dương Duy',N'Nam', '06/12/2019','0473526483');
SELECT*FROM NHANVIEN

----xoa triggger:
DROP TRIGGER TRG_THEMNV

go
---3.Viết trigger kiểm tra khi thêm dữ liệu,update vào thuephong ngay thue không được lớn hơn ngày hien tai
CREATE TRIGGER TRG_THEMNGAYTHUE ON THUEPHONG
FOR INSERT,UPDATE
AS
BEGIN
	IF((SELECT NgayVao FROM inserted)>GETDATE())
	BEGIN
		PRINT N'NGÀY RA HOÁ ĐƠN KHÔNG ĐƯỢC LỚN HƠN NGÀY HIỆN TẠI'
		ROLLBACK TRAN
	END
END
go
----INSERT NHAN VIEN DUNG:

SET DATEFORMAT DMY
INSERT INTO THUEPHONG VALUES('MT11','KH09','MP001', '14/06/2020' ,'15/06/2020',null );
----INSERT NHAN VIEN SAI:

SET DATEFORMAT DMY
 INSERT INTO THUEPHONG VALUES('MT12','KH09','MP001', '15/05/2021' ,'15/06/2020',null );

SELECT*FROM THUEPHONG
--XOA TRIGGER:
DROP TRIGGER TRG_THEMNGAYTHUE

GO
---4.không cho phép xóa thông tin của nhân viên có tuổi lớn hơn 20
create trigger UTG_DELETENV on NHANVIEN
FOR DELETE
	AS
		BEGIN
		DECLARE @COUNT INT=0;
		SELECT @COUNT=COUNT(*) FROM deleted
		WHERE YEAR(GETDATE())-YEAR(deleted.NgaySinh)>20
		IF(@COUNT>0)
		BEGIN
		PRINT N'KHONG DC XOA NHAN VIEN LON HON 20'
		ROLLBACK TRAN
		END

		END
GO
---Xoa trigger dung:
DELETE NHANVIEN  WHERE MaNV='NV009'
--------Xoa trigger sai:
SET DATEFORMAT DMY
INSERT INTO NHANVIEN VALUES('NV022','202cb962ac59075b964b07152d234b70',N'Dương Duy Hà',N'Nữ', '10/03/2000','0473526483');

DELETE NHANVIEN  WHERE MaNV='NV022'
SELECT*FROM NHANVIEN
------XOA TRIGGER
DROP TRIGGER TRG_THEMNGAYTHUE
GO
--------5:Them 1 loai phong để biết tên loại phòng có tồn tại chưa hay không
CREATE TRIGGER TG_ThemLP ON LOAIPHONG INSTEAD OF INSERT
AS
	IF NOT EXISTS(SELECT * FROM LOAIPHONG

		WHERE MaLoai =(SELECT MaLoai FROM INSERTED))

		BEGIN
		INSERT INTO LOAIPHONG(MaLoai, TenLoai)

		SELECT MaLoai, TenLoai FROM INSERTED

		END
	ELSE

		PRINT N'TÊN LOẠI PHÒNG HOẶC MÃ LOẠI PHÒNG  ĐÃ TỒN TẠI'

GO

select*from LOAIPHONG
-----them loai phòng dung:
INSERT INTO LOAIPHONG  VALUES('LP006',N'PHÒNG 4 GIƯỜNG');
-----them loai phòng sai:
INSERT INTO LOAIPHONG  VALUES('LP005',N'PHÒNG 4 GIƯỜNG');
--xoa trigger
drop trigger TG_ThemLP
GO

-------6:UPDATE ,insert  CHO BANG THUEPHONG với ngày thuê phải nhỏ hơn ngày trả phòng

CREATE TRIGGER TG_THUEPHONG ON THUEPHONG
FOR INSERT,UPDATE
AS
BEGIN
	IF((SELECT NgayRa FROM inserted)<(SELECT NgayVao  FROM inserted))
	BEGIN
		PRINT N'ngay thue phai nho hon hoac bang ngay tra'
		ROLLBACK TRAN
	END
END
GO

----insert dung:
SET DATEFORMAT DMY
INSERT INTO THUEPHONG VALUES('MT012','KH01','MP008', '24/12/2021' ,'25/12/2021',null  );
--insert sai:
SET DATEFORMAT DMY
INSERT INTO THUEPHONG VALUES('MT013','KH01','MP008', '26/12/2021' ,'25/12/2021',null  );

SELECT * FROM THUEPHONG
--xoa trigger
drop trigger TG_THUEPHONG
go

-----7.Viết trigger khi xoá 1 dòng dữ liệu trong bảng khach hang   thì trong bảng thue phong   có khach hang   đó cũng xoá theo.
--CREATE TRIGGER TG_XOAKHACH1 ON KHACHHANG
--INSTEAD OF DELETE
--AS
--BEGIN
--		DECLARE @MaKH CHAR(10)
--		SET @MaKH=(SELECT MaKH FROM deleted)
--		DELETE KHACHHANG WHERE MaKH=@MaKH
--		DELETE THUEPHONG WHERE MaKH=@MaKH
--END
--go
--delete from KHACHHANG where  MaKH='KH03'
--SELECT*FROM KHACHHANG
--SELECT*FROM THUEPHONG
go
----------------------------------------------------------CÁC CURSOR---------------------------------------------------------------------------

---1.Viết thủ tục kết hợp cusor truyền vào mã phong  sẽ in ra danh sách bao gồm:mã phòng ,tên khách hàng dg thue

CREATE PROC PROC_CS_CAU1
@MaPhong CHAR(20)
AS
BEGIN
	DECLARE @BANGTHONGKE TABLE(MaPhong  CHAR(20),TenKH NVARCHAR(50))
	DECLARE CS_CAU1 CURSOR
	FOR SELECT tp.MaThue,kh.TenKH from THUEPHONG tp,KHACHHANG kh WHERE tp.MaKH=kh.MaKH AND tp.MaPhong=@MaPhong
	OPEN CS_CAU1
	DECLARE @MaThue CHAR(20),@TenKH NVARCHAR(50)
	FETCH NEXT FROM CS_CAU1 INTO @MaThue,@TenKH
	WHILE(@@FETCH_STATUS=0)
	BEGIN
		
		INSERT INTO @BANGTHONGKE SELECT @MaPhong,@TenKH
		FETCH NEXT FROM CS_CAU1 INTO @MaThue,@TenKH	
	END
	CLOSE CS_CAU1
	DEALLOCATE CS_CAU1
	SELECT *FROM @BANGTHONGKE
END

----thuc thi
EXEC PROC_CS_CAU1 'MP001'

select*from KHACHHANG
select*from THUEPHONG
select*from  PHONG
go


-----2:Kết hợp cursor, viết hàm truyền vào mã khách  và in ra danh sách các 
--thông tin liên quan đến khách hàng  đó gồm: họ tên khách hàng ,địa chỉ ,số điện thoại , mã phòng , ngày vào ,ngày ra,tienthue

CREATE FUNCTION FUNC_DSKHH1 (@MAKH CHAR(20))
RETURNS @BANGTHONGKE TABLE(TENKHACH NVARCHAR(50),DIACHI NVARCHAR(50),SODT CHAR(15),MAPHONG CHAR(10),NGAYVAO DATE ,NGAYRA DATE)
AS
	BEGIN
		DECLARE CS_CAU2 CURSOR 
		FOR SELECT KH.TenKH,KH.DiaChi,KH.SoDT,TH.MaPhong,TH.NgayVao,TH.NgayRa FROM KHACHHANG KH,THUEPHONG TH WHERE KH.MaKH=TH.MaKH AND KH.MaKH=@MAKH
		OPEN CS_CAU2
		DECLARE @TENKHACH NVARCHAR(50),@DIACHI NVARCHAR(50),@SODT CHAR(15),@MAPHONG CHAR(10),@NGAYVAO DATE ,@NGAYRA DATE
		FETCH NEXT FROM CS_CAU2 INTO @TENKHACH,@DIACHI,@SODT,@MAPHONG,@NGAYVAO,@NGAYRA
		WHILE(@@FETCH_STATUS=0)
		BEGIN

		INSERT INTO @BANGTHONGKE SELECT @TENKHACH,@DIACHI,@SODT,@MAPHONG,@NGAYVAO,@NGAYRA
		FETCH NEXT FROM CS_CAU2 INTO @TENKHACH,@DIACHI,@SODT,@MAPHONG,@NGAYVAO,@NGAYRA
		END
	CLOSE CS_CAU2
	DEALLOCATE CS_CAU2
	RETURN
	END

GO
---thuc thi
SELECT *FROM DBO.FUNC_DSKHH1('KH06')

SELECT*FROM KHACHHANG
SELECT*FROM THUEPHONG

GO
-----3.in ra danh sach ten va dia chi cua khách hang

declare cur_khachhang cursor 
for select TenKH,DiaChi  from KHACHHANG
declare @tenKH nvarchar(50),@diaChi nvarchar(100)
print N'Danh sach khách hàng'
open cur_khachhang 
fetch next from cur_khachhang  into @TenKH,@DiaChi
while(@@FETCH_STATUS=0)
begin
	print @TenKH +'  '+@DiaChi
	print '---------------------------------'
	fetch next from cur_khachhang  into @TenKH,@DiaChi


end
close cur_khachhang
deallocate cur_khachhang

select*from KHACHHANG
go

-----4.dùng cấu trúc cursor để cập nhật giá trị vào cột Gia Dịch Vụ với điều kiện như sau:
	--TenDV=Café:GiaDV+=2;
	--TenDV=Spa:GiaDV+=1;
	--TenDV=Giặt ủi:GiaDV+=0;(CAC LOAI CON LAI LA KHONG CONG)
DECLARE CAPNHAT CURSOR
FOR SELECT MaDV,TenDV,GiaDV FROM DICHVU
FOR UPDATE OF GiaDV

OPEN CAPNHAT

DECLARE @MADV VARCHAR(10),@TENDV NVARCHAR(30),@GIA FLOAT
FETCH NEXT FROM CAPNHAT INTO @MADV ,@TENDV,@GIA 
WHILE(@@FETCH_STATUS=0)
BEGIN 
	IF(@TENDV=N'Café')
	SET @GIA+=2
	ELSE IF(@TENDV=N'Spa')
		SET @GIA+=1
		ELSE
		SET @GIA+=0

	UPDATE DICHVU
	SET GiaDV=@GIA
	WHERE MaDV=@MADV
	FETCH NEXT FROM CAPNHAT INTO @MADV ,@TENDV,@GIA 
END

CLOSE CAPNHAT
DEALLOCATE CAPNHAT

SELECT*fROM DICHVU
GO


-----------------------------------------------------------------------BACKUP-----------------------------------------------------------------
CREATE DATABASE QL_KHACHSAN
GO
USE QL_KHACHSAN
GO
--------------------
--ĐƯA RECOVERY VỀ FULL
alter  DATABASE QL_KHACHSAN SET RECOVERY FULL
--thoi diem t1:full backup,tham so WITH INIT cho phep ghi de len file hien tai
BACKUP DATABASE  QL_KHACHSAN TO DISK='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KHACHSAN_FULL.bak' 
WITH INIT
GO

--THOI DIEM T2:differential backup
BACKUP DATABASE QL_KHACHSAN  TO DISK='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KHACHSAN_DIFF.bak'
WITH DIFFERENTIAL
GO

--THOI DIEM 3:TRANSACTION LOG BACKUP 
--KHONG COS THAM SO WITH INIT DE BO SUNG VAO BAN LOG TRUOC DO 
BACKUP LOG QL_KHACHSAN TO DISK='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KHACHSAN_LOG.trn'
go

------------------------------------------------------------RESTORE----------------------------------------------------------------- 
--gia su sau do xay ra u co(gia su databse QL_KHACHSAN BI XOA).
USE MASTER
GO
DROP DATABASE QL_KHACHSAN;

--BUOC 1: KHOI PHUC TU BANFULL BACKUP. THAM SO" WITH NORECOVERY" DE SAU MOI LENH 
RESTORE DATABASE QL_KHACHSAN FROM DISK='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KHACHSAN_FULL.bak' 
WITH NORECOVERY
GO
--BUOC 2: KHOI PHUC TU BANG DIDDERENTIAL BACKUP
RESTORE DATABASE QL_KHACHSAN FROM DISK='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KHACHSAN_DIFF.bak'
 WITH NORECOVERY
GO
--BUOC 3: KHOI PHUC TU CACS BAN TRANSACTION LOG BACKUP THEO TRINH TU THOI GIAN
RESTORE DATABASE QL_KHACHSAN FROM DISK='D:\2020-2021\Do_An(2020-2021)\Do_An_DBMS\VoThiThuHa_NguyenNgocThanhThuy\KHACHSAN_LOG.trn' 
GO
--KIEM TRA LAI SAU KHI KHOI PHUC
USE QL_KHACHSAN
go
SELECT*FROM KHACHHANG
SELECT*FROM NHANVIEN
SELECT*FROM PHONG
SELECT*FROM THANHTOAN

GO

-------------------------------------------------------------PHÂN QUYỀN------------------------------------------------------------

--tạo tài khoản đăng nhập HA ,THUY

sp_addlogin 'HA','1003'
go
sp_addlogin 'THUY','1003'
go
--XOA tài khoản đăng nhập HA ,THUY
sp_droplogin 'HA'
go
sp_droplogin 'THUY'
go

--tạo tài khoản người dùng thuha  cho tài khoản đăng nhập HA
use QL_KHACHSAN
go
sp_adduser 'HA','thuha'
go
--tạo tài khoản người dùng thanhthuy cho tài khoản đăng nhập THUY
sp_adduser 'THUY','thanhthuy'
go
-----xoa tai khoan nguoi dung
sp_dropuser 'thuha'
go
sp_dropuser 'thanhthuy'
go

--tạo nhóm quyền 'giamdoc'
sp_addrole 'giamdoc'
go
----huy nhom quyen
sp_droprole 'giamdoc'
go
--phân quyền cho nhóm quyền dữ liệu xem,thêm ,chỉnh sửa,xoá cho bảng THUEPHONG,KHACHHANG
--bảng THUEPHONG
grant select,insert,update,delete
on THUEPHONG
to giamdoc
--bảng KHACHHANG
grant select,insert,update,delete
on KHACHHANG
to giamdoc
go
--add user thuha,thanhthuy vào nhóm quyền giamdoc
sp_addrolemember 'giamdoc','thuha'
go
sp_addrolemember 'giamdoc','thanhthuy'
GO
---Xoá người dùng thuha khỏi nhóm quyền giamdoc
sp_droprolemember 'giamdoc','thuha'
GO 
---Xoá người dùng thanhthuy khỏi nhóm quyền giamdoc
sp_droprolemember 'giamdoc','thanhthuy'
GO 
--them quyền thêm,chỉnh sửa,xoá bảng khachhang cho user thanhthuy
grant insert,update,delete
on PHONG
to thanhthuy

--Gán quyền thêm,chỉnh sửa,xoá bảng nhanvien cho nhom quyen giamdoc
grant insert,update,delete
on NHANVIEN
to giamdoc

---Thu hồi các quyền insert,update,delete trên bảng NHANVIEN từ nhóm quyền giamdoc.
REVOKE insert,update,delete
ON NHANVIEN
FROM giamdoc


---
