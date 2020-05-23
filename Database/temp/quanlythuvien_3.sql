-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2020 at 06:05 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `tkAdmin` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password_hashed` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RFID_code` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`tkAdmin`, `password`, `password_hashed`, `RFID_code`) VALUES
('AD000001', '123456datluu', NULL, '64 6B A5 18');

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `maPhieuMuon` varchar(7) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `IDSach` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maNhap` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGia` int(11) NOT NULL,
  `thanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `maXuat` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietsach`
--

CREATE TABLE `chitietsach` (
  `IDSach` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `tinhTrang` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitietsach`
--

INSERT INTO `chitietsach` (`IDSach`, `maSach`, `tinhTrang`) VALUES
('IDS000001', 'S000001', 'Tốt'),
('IDS000002', 'S000001', 'Bình Thường'),
('IDS000003', 'S000001', 'Cũ'),
('IDS000004', 'S000002', 'Tốt'),
('IDS000005', 'S000002', 'Bình Thường'),
('IDS000006', 'S000002', 'Cũ'),
('IDS000007', 'S000003', 'Tốt'),
('IDS000008', 'S000003', 'Bình Thường'),
('IDS000009', 'S000003', 'Cũ'),
('IDS000010', 'S000004', 'Tốt'),
('IDS000011', 'S000004', 'Bình Thường'),
('IDS000012', 'S000004', 'Cũ'),
('IDS000013', 'S000005', 'Tốt'),
('IDS000014', 'S000005', 'Tốt'),
('IDS000015', 'S000005', 'Bình Thường'),
('IDS000016', 'S000005', 'Bình Thường'),
('IDS000017', 'S000005', 'Cũ'),
('IDS000018', 'S000006', 'Tốt'),
('IDS000019', 'S000006', 'Tốt'),
('IDS000020', 'S000006', 'Bình Thường'),
('IDS000021', 'S000006', 'Cũ'),
('IDS000022', 'S000007', 'Tốt'),
('IDS000023', 'S000007', 'Tốt'),
('IDS000024', 'S000007', 'Bình Thường'),
('IDS000025', 'S000007', 'Cũ'),
('IDS000026', 'S000008', 'Tốt'),
('IDS000027', 'S000008', 'Tốt'),
('IDS000028', 'S000008', 'Bình Thường'),
('IDS000029', 'S000008', 'Cũ'),
('IDS000030', 'S000009', 'Tốt'),
('IDS000031', 'S000009', 'Bình Thường'),
('IDS000032', 'S000009', 'Cũ'),
('IDS000033', 'S000010', 'Tốt'),
('IDS000034', 'S000010', 'Tốt'),
('IDS000035', 'S000010', 'Bình Thường'),
('IDS000036', 'S000010', 'Cũ'),
('IDS000037', 'S000011', 'Tốt'),
('IDS000038', 'S000011', 'Bình Thường'),
('IDS000039', 'S000011', 'Cũ'),
('IDS000040', 'S000012', 'Tốt'),
('IDS000041', 'S000012', 'Bình Thường'),
('IDS000042', 'S000012', 'Cũ'),
('IDS000043', 'S000013', 'Tốt'),
('IDS000044', 'S000013', 'Bình Thường'),
('IDS000045', 'S000013', 'Cũ'),
('IDS000046', 'S000014', 'Tốt'),
('IDS000047', 'S000014', 'Bình Thường'),
('IDS000048', 'S000014', 'Cũ'),
('IDS000049', 'S000015', 'Tốt'),
('IDS000050', 'S000015', 'Bình Thường'),
('IDS000051', 'S000015', 'Cũ'),
('IDS000052', 'S000016', 'Tốt'),
('IDS000053', 'S000016', 'Bình Thường'),
('IDS000054', 'S000016', 'Cũ'),
('IDS000055', 'S000017', 'Tốt'),
('IDS000056', 'S000017', 'Bình Thường'),
('IDS000057', 'S000017', 'Cũ'),
('IDS000058', 'S000018', 'Tốt'),
('IDS000059', 'S000018', 'Bình Thường'),
('IDS000060', 'S000018', 'Cũ'),
('IDS000061', 'S000019', 'Tốt'),
('IDS000062', 'S000019', 'Bình Thường'),
('IDS000063', 'S000019', 'Cũ'),
('IDS000064', 'S000020', 'Tốt'),
('IDS000065', 'S000020', 'Bình Thường'),
('IDS000066', 'S000020', 'Cũ'),
('IDS000067', 'S000021', 'Tốt'),
('IDS000068', 'S000021', 'Bình Thường'),
('IDS000069', 'S000021', 'Cũ'),
('IDS000070', 'S000022', 'Tốt'),
('IDS000071', 'S000022', 'Bình Thường'),
('IDS000072', 'S000022', 'Cũ'),
('IDS000073', 'S000023', 'Tốt'),
('IDS000074', 'S000023', 'Bình Thường'),
('IDS000075', 'S000023', 'Cũ'),
('IDS000076', 'S000024', 'Tốt'),
('IDS000077', 'S000024', 'Bình Thường'),
('IDS000078', 'S000024', 'Cũ');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `maKhachHang` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `hoTen` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(65) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `maThe` varchar(7) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`maKhachHang`, `hoTen`, `ngaySinh`, `diaChi`, `sdt`, `email`, `maThe`) VALUES
('KH000001', 'Nguyễn Thùy Chi', '1999-01-29', 'Tỉnh Lộ 10, Quận Bình Tân, TP HCM', '0321589102', 'thuychi@gmail.com', 'T000001'),
('KH000002', 'Nguyễn Minh Khang', '2000-02-12', 'Phan Anh, Quận Tân Phú, TP HCM', '0951786905', 'khangnguyen@gmail.com', 'T000002'),
('KH000003', 'Lê Bảo Trân', '1997-11-22', 'Hồ Ngọc Cẩn, Huyện Hóc Môn, TP HCM', '0985327812', 'baotran@gmail.com', 'T000003'),
('KH000004', 'Lê Quốc Bình', '2001-09-22', 'Tỉnh Lộ 9, Huyện Củ Chi, TP HCM', '0904281742', 'binhle@gmail.com', 'T000004'),
('KH000005', 'Phạm Diệu Linh', '1998-09-09', 'Phạm Văn Sáng, Huyện Bình Chánh, TP HCM', '0762190538', 'dieulinh@gmail.com', 'T000005'),
('KH000006', 'Phạm Hùng Cường', '1996-08-27', 'Nguyễn Huy Tưởng, Quận Bình Thạnh, TP HCM', '0351298632', 'cuongpham@gmail.com', 'T000006'),
('KH000007', 'Đặng Trúc Lâm', '1997-06-14', 'Cây Trâm, Quận Gò Vấp, TP HCM', '0924582906', 'truclam@gmail.com', 'T000007'),
('KH000008', 'Đặng Minh Quân', '2000-11-23', 'Trần Quang Diệu, Quận Phú Nhuận, TP HCM', '0705643219', 'quandang@gmail.com', 'T000008'),
('KH000009', 'Đỗ Đan Hạ', '1997-09-07', 'Ngự Bình, Quận Tân Bình, TP HCM', '0399641785', 'danha@gmail.com', 'T000009'),
('KH000010', 'Đỗ Thái Dương', '1998-10-10', 'Phạm Văn Đồng, Quận Thủ Đức, TP HCM\r\n', '0761297518', 'duongdo@gmail.com', 'T000010'),
('KH000011', 'Hoàng Vân Khánh', '1999-08-19', 'An Thới Đông, Huyện Cần Giờ, TP HCM', '0388127529', 'vankhanh@gmail.com', 'T000011'),
('KH000012', 'Hoàng Vân Phong', '1997-04-02', 'Chánh Hưng, Huyện Nhà Bè, TP HCM', '0982437581', 'phonghoang@gmail.com', 'T000012'),
('KH000013', 'Đinh Nhã Uyên', '1998-10-24', 'Quang Trung, Quận 12, TP HCM', '0937841679', 'nhauyen@gmail.com', 'T000013'),
('KH000014', 'Đinh Gia Khánh', '1996-06-11', 'Nguyễn Công Trứ, Quận 9, TP HCM', '0318951479', 'khanhdinh@gmail.com', 'T000014'),
('KH000015', 'Phan Mẫn Nhi', '1999-05-07', 'Nguyễn Tri Phương, Quận 7, TP HCM', '0985241788', 'nhiphan@gmail.com', 'T000015'),
('KH000016', 'Phan Tấn Gia Hưng', '0000-00-00', 'An Dương Vương, Quận 5, TP HCM', '0921686578', 'hungphan@gmail.com', 'T000016'),
('KH000017', 'Vũ Hà My', '2000-08-06', 'Tôn Đản, Quận 4, TP HCM', '0367189002', 'hamy@gmail.com', 'T000017'),
('KH000018', 'Vũ Trung Nghĩa', '1999-11-20', 'Nguyễn Thượng Hiền, Quận #, TP HCM', '0915738940', 'nghiavu@gmail.com', 'T000018'),
('KH000019', 'Huỳnh Ngọc Bích', '1998-10-28', 'Mạc Đĩnh Chi, Quận 1, TP HCM', '0974135863', 'ngocbich@gmail.com', 'T000019'),
('KH000020', 'Huỳnh Anh Việt', '1999-03-08', 'Nguyễn Thị Định, Quận 2, TP HCM', '0357189582', 'viethuynh@gmail.com', 'T000020');

-- --------------------------------------------------------

--
-- Table structure for table `khosach`
--

CREATE TABLE `khosach` (
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khosach`
--

INSERT INTO `khosach` (`maSach`, `soLuong`) VALUES
('S000001', 5),
('S000002', 5),
('S000003', 5),
('S000004', 5),
('S000005', 20),
('S000006', 20),
('S000007', 20),
('S000008', 15),
('S000009', 10),
('S000011', 6),
('S000010', 15),
('S000012', 8),
('S000013', 5),
('S000014', 16),
('S000015', 12),
('S000016', 9),
('S000017', 10),
('S000018', 18),
('S000019', 17),
('S000020', 18),
('S000021', 7),
('S000022', 10),
('S000023', 11),
('S000024', 4);

-- --------------------------------------------------------

--
-- Table structure for table `loaisach`
--

CREATE TABLE `loaisach` (
  `maSach` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `tenSach` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tenTacGia` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tenNXB` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `namXB` int(4) NOT NULL,
  `theLoai` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngonNgu` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tomTatNoiDung` text COLLATE utf8_unicode_ci NOT NULL,
  `giaTien` int(11) NOT NULL,
  `soTrang` int(11) NOT NULL,
  `hinhSach` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soLuongTong` int(11) NOT NULL,
  `soLuongMuon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaisach`
--

INSERT INTO `loaisach` (`maSach`, `tenSach`, `tenTacGia`, `tenNXB`, `namXB`, `theLoai`, `ngonNgu`, `tomTatNoiDung`, `giaTien`, `soTrang`, `hinhSach`, `soLuongTong`, `soLuongMuon`) VALUES
('S000001', 'Tập Tục Đời Người', 'Phan Cẩm Thượng', 'Nhà Xuất Bản Hội Nhà Văn', 2017, 'Sách Văn Hóa', 'Tiếng Việt', '“Bạn đang cầm trên tay cuốn thứ hai trong một bộ sách của Phan Cẩm Thượng […] gồm bốn cuốn, sẽ hoàn thành trong 4 đến 5 năm nữa. Một bộ sử Việt Nam. Nhưng cần nói rõ: không phải lịch sử nước Việt với tư cách một quốc gia, mà là lịch sử người Việt Nam trong cuộc sống làm người hằng ngày của họ. Phan Cẩm Thượng không viết về các triều đại hưng suy, các cuộc chiến tranh thắng thua khốc liệt, các biến cố chính trị được coi là trọng đại … như ta thường gặp trong những bộ quốc sử nghiêm trang. Ở đây ta gặp một cái khác, nhỏ nhoi hơn, thường nhật và gần gũi hơn (nhưng kỳ vậy, lại ít được biết đến hơn): những con người. Con người Việt Nam. Phan Cẩm Thượng cho thấy còn có một lịch sử khác nữa như vậy của đất nước này mà ta chưa thật biết, song lại cũng quan trọng không kém, nếu không hơn. Vâng, có thể còn hơn, bởi vì con người phải sống như thế này, làm những cái này trước, rồi mới có thể làm những cái được coi là trọng đại kia. Mới có thể làm nên Lịch sử ‘lớn’. Hoặc nói cho cùng, những cái to lớn, trọng đại kia, theo cách nào đó rất có thể do chính những cái này chi phối, thậm chí đến quyết định. Vì nó có trước. Nó là cái nền. Nó bền bỉ và lâu dài hơn các triều đại và các chế độ.”', 189000, 611, NULL, 0, 0),
('S000002', 'Việt Nam Phong Tục', 'Phan Kế Bính', 'Nhà Xuất Bản Hồng Đức', 2019, 'Sách Văn Hóa', 'Tiếng Việt', 'Từ Phong tục trong gia tộc, Phong tục xóm làng (hương đảng) đến các phong tục ngoài xã hội, VIỆT NAM PHONG TỤC của học giả PHAN KẾ BÍNH là một bộ biên khảo tương đối đầy đủ về các phong tục tập quán cũ của nước Việt. Là một nhà nho uyên bác mang tư tưởng tân tiến, tác giả không chỉ mô tả từng tập tục, mà còn về gốc tích, nguyên ủy cái tục ấy, nhìn nhận, đánh giá để xem nó hay hay dở, từ đó \"xét điều gì quá tệ mà bỏ bớt đi, rồi lâu lâu mới đem cái tục hay mà bổ hết cho cái tục dở. Còn tục gì hay mà là quốc túy của ta thì cứ giữ lấy\". Đến nay, tập sách gần một trăm năm tuổi này vẫn là một trong những công trình khảo cứu có giá trị bậc nhất về các phong tục tập quán trên đất nước ta và nhiều vấn đề được PHAN KẾ BÍNH nhắc tới vẫn nóng hổi tính thời đại.', 90000, 306, NULL, 0, 0),
('S000003', ' Văn Hóa Tín Ngưỡng Việt Nam', 'Nguyễn Hạnh', 'Nhà Xuất Bản Trẻ', 2020, 'Sách Văn Hóa', 'Tiếng Việt', 'Tác phẩm Văn Hóa Tín Ngưỡng Việt Nam của tác giả Nguyễn Hạnh là tác phẩm biên khảo về tín ngưỡng của người Việt khởi từ thời dựng nước với khái niệm thờ: Trời, đất, tổ tiên. Những niềm tin dân gian của ông bà ta xưa vẫn còn lưu truyền đến ngày nay thông qua kho tàng ca dao.Tiếp đến là sự giao thoa văn hóa với 4 tôn giáo lớn ở Việt Nam là Nho, Phật, Lão, Công Giáo. Chính sự giao thoa giữa tín ngưỡng dân gian Việt Nam và 4 tôn giáo lớn này đã hình thành nên nhiều tôn giáo bản địa như Cao Đài, Hòa Hảo, Hòa Đồng Tôn Giáo. Sự giao thoa, tiếp thu và chọn lọc đó đã làm nên một đặc sắc trong chiều kích tâm linh đó là các tôn giáo du nhập phải được điều chỉnh và chứa đựng được yếu tố tín ngưỡng của người Việt. Chính những ảnh hưởng giao thoa này góp phần tạo nên bản sắc văn hóa, tín ngưỡng của người Việt xuyên suốt từ thuở dựng nước đến nay. Tác phẩm Văn Hóa Tín Ngưỡng Việt Nam sẽ góp phần làm phong phú thêm Tủ sách Triết học phương Đông của NXB Trẻ và là quyển sách cần thiết cho độc giả tìm hiểu về cội nguồn tín ngưỡng của người Việt.', 100000, 232, NULL, 0, 0),
('S000004', 'Nghề Cổ Nước Việt Từ Truyền Thống Đến Hiện Đạ', 'Vũ Từ Trang', 'Nhà Xuất Bản Phụ Nữ', 2020, 'Sách Văn Hóa', 'Tiếng Việt', '“Trong suốt hai trăm năm công nghiệp hóa và đô thị hóa, nhân loại mất đi nhiều nghề thủ công truyền thống không bao giờ phục hồi lại được nữa. Cho đến xã hội thông tin và công nghệ toàn cầu hiện nay, với sự phát triển toàn diện của ngành design, các nghề thủ công cổ được nhìn nhận lại, trước tiên phục vụ cho công việc bảo tồn di sản vật thể và phi vật thể, sau đó là những ngành design thủ công và độc bản cũng có cơ hội kinh doanh. Việt Nam không nằm ngoài vấn đề này, mặc dù công nghiệp của nước ta chậm phát triển, chỉ trong thế kỷ 20, nhưng do chiến tranh, những chính sách kinh tế không thích hợp, nhiều làng nghề thủ công và nghệ thủ công truyền thống cũng suy thoái và biến mất.\r\n\r\nCho đến nay, không có một thống kê chính xác Việt Nam từng có bao nhiêu làng nghề, phường nghề và nghề thủ công truyền thống, cái nào mất, cái nào còn, cái nào biến đổi trong cơ giới hóa và dây chuyền, gần đây còn là áp dụng công nghệ, ví dụ tiện chạm công nghệ theo mẫu mã, hoặc in 3D. Sách về làng nghề và thủ công truyền thống không nhiều và cũng chưa thật đi sâu vào chuyên môn mang tính kỹ thuật, lý do là ngành nghiên cứu Việt Nam không có truyền thống và rất hạn chế về đầu tư, những người biết nghề thì có xu hướng giữ kín nghề nghiệp, nên không bao giờ công bố các công thức và kỹ nghệ, những người viết về làng nghề và nghề thủ công chủ yếu là các nhà văn hóa có hạn chế nhất định về tay nghề và cũng chẳng có ai có thể nắm được mọi kỹ thuật nghề nghiệp mà viết từng nghề cho rành rọt. Đây là công việc của nhiều thế hệ và nhiều người. Việc những nhà văn hóa viết về làng nghề và nghề thủ công đã là quý lắm, bởi họ có ý thức giữ gìn truyền thống trong khả năng có thể.\r\n\r\nCuốn Nghề cổ nước Việt – từ truyền thống đến hiện đại” của Vũ Từ Trang, ra mắt trong năm nay, do Nhà xuất bản Phụ nữ ấn hành, là một công trình đáng kể, sau nhiều năm hoạt động văn chương và nghiên cứu văn hóa của tác giả. Ông xuất thân là một trí thức làng Sặt (Trang Liệt) ở Từ Sơn, Bắc Ninh, quê hương của nhiều di sản văn hóa và làng nghề, nguyên việc khảo cứu làng nghề Kinh Bắc xưa đối với ông là hoàn toàn thuận lợi và các làng nghề Kinh Bắc cũng cởi mở hơn rất nhiều nơi khác trong việc cung cấp thông tin cho người nghiên cứu. Vũ Từ Trang từng 20 năm làm phóng viên chuyên theo dõi và viết về đề tài tiểu thủ công nghiệp. Từng được đi hầu hết các làng nghề thủ công truyền thống.\r\n\r\nTập sách với 25 nghề cổ...', 265000, 700, NULL, 0, 0),
('S000005', 'Giáo Trình Kỹ Thuật Lập Trình C Căn Bản Và Nâ', 'GS. Phạm Văn Ất', 'Nhà Xuất Bản Bách Khoa Hà Nội', 2018, 'Sách Công Nghệ Thông Tin', 'Tiếng Việt', 'Giáo trình kỹ thuật lập trình C căn bản và nâng cao được hình thành qua nhiều năm giảng dạy của các tác giả. Ngôn ngữ lập trình C là một môn học cơ sở trong chương trình đào tạo kỹ sư, cử nhân tin học của nhiều trường đại học. Ở đây sinh viên được trang bị những kiến thức cơ bản nhất về lập trình, các kỹ thuật  tổ chức dữ liệu và lập trình căn bản với ngôn ngữ C.\r\n\r\nĐể đáp ứng nhu cầu học tập ngôn ngữ lập trình C của sinh viên cũng như nhu cầu về tài liệu cho mọi người trong nhiều ngành khoa học và kỹ thuật cần nghiên cứu C để giải quyết các bài toán của mình, tác giả biên soạn cuốn sách này. Nội dung cuốn sách là tập hợp một cách có chọn lọc các bài giảng của các tác giả.', 135000, 440, NULL, 0, 0),
('S000006', 'Lập Trình Với C#', 'Phạm Quang Huy', 'Nhà Xuất Bản Thanh Niên', 2019, 'Sách Công Nghệ Thông Tin', 'Tiếng Việt', 'Hướng dẫn người học từng bước lập trình với C#. Xây dựng ứng dụng trên Window Form.\r\nXây dựng ứng dụng, tạo hai trang web quản lý bán hàng và quản lý tuyển sinh với các hướng dẫn từng bước làm cơ sở cho việc thiết kế các trang web phức tạp hơn.\r\nGiá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Tuy nhiên tuỳ vào từng loại sản phẩm hoặc phương thức, địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, ...', 125000, 392, NULL, 0, 0),
('S000007', 'Lập Trình Hệ Thống Thương Mại Điện Tử', 'Phạm Quang Hiển', 'Nhà Xuất Bản Thanh Niên', 2019, 'Sách Công Nghệ Thông Tin', 'Tiếng Việt', 'Thương mại điện tử là gì? Là quá trình tiến hành một phần hay toàn bộ hoạt động thương mại thông qua những phương tiện điện tử hiện đại. Về bản chất, thương mại điện tử không thay đổi so với các hoạt động thương mại truyền thống. Tuy nhiên, bằng các phương tiện điện tử mới, các hoạt động giao dịch, mua bán, quảng bá được thực hiện nhanh chóng, hiệu quả hơn, giúp tiết kiệm chi phí và mở rộng phạm vi kinh doanh.\r\nVới những kiến thức và thế mạnh về xây dựng chiến lược kinh doanh, kỹ năng nghiệp vụ liên quan trong lĩnh vực công nghệ, tin học, ngoại ngữ, sinh viên tốt nghiệp ngành Thương mại điện tử có rất nhiều cơ hội việc làm hấp dẫn từ Phòng marketing; Phòng nghiệp vụ kinh doanh; Phòng kế hoạch; Phòng tin họở các công ty, tập đoàn trong và ngoài nước.', 160000, 582, NULL, 0, 0),
('S000008', 'Sách Lập Trình Với Scratch 3.0', 'Nguyễn Hữu Hưng', 'Nhà Xuất Bản Đại Học Quốc Gia Hà Nội', 2017, 'Sách Công Nghệ Thông Tin', 'Tiếng Việt', 'Mục đích cuốn sách\r\nGiới thiệu về ngôn ngữ lập trình kéo thả phổ biến nhất thế giới cho học sinh phổ thông, Scratch 3.0 (phiên bản mới, phát hành năm 2019). Cuốn sách kế thừa hoàn toàn những quan điểm về nội dung, cách trình bày của cuốn sách “Lập trình với Scratch” xuất bản năm 2016 tại NXBGD (viết cho phiên bản Scratch 2.0), đồng thời bổ sung những thông tin mới về giao diện, cách lập trình cũng như các khối lệnh của phiên bản Scratch 3.0. Giúp người học nhanh chóng làm chủ hoàn toàn cách sử dụng Scratch 3.0 thông qua từng bước hướng dẫn thiết kế và lập trình ra 05 chương trình mẫu theo cấp độ từ dễ đến khó. Trên cơ sở đó người học có thể tự tạo ra các ứng dụng trò chơi, ứng dụng hỗ trợ học tập nghiên cứu hoặc đơn giản như làm tấm thiệp hay bộ phim hoạt hình, tùy theo trình độ cũng như  ý tưởng của riêng mình.\r\nTầm quan trọng của bộ môn lập trình kéo thả\r\nCuốn sách được xuất bản điện tử và chia sẻ công khai bản PDF nhằm mục đích đồng hành và dẫn dắt các em tiến tới kỷ nguyên mới, kỷ nguyên 4.0 - thời đại của robot và trí tuệ nhân tạo phát triển. Trong thời đại này, lập trình không chỉ là môn học thiết yếu mà còn là kỹ năng cơ bản và cũng được đánh giá quan trọng không khác gì kỹ năng đọc và viết. Lập Trình đang trở thành một môn học mới và được phổ cập tại nhiều quốc gia trên thế giới trong đó có Việt Nam.\r\nMô tả\r\nCuốn sách viết về ngôn ngữ lập trình Scratch với phiên bản Scratch 3.0 (phiên bản mới)  theo quan điểm: Thực hành - Trải nghiệm - Trực quan với những ví dụ được sử dụng trong cuốn sách đều rất gần gũi với học sinh. Việc lập trình những sản phẩm gắn với thực tế sẽ kích thích các em nhỏ tìm tòi, khám phá những sự vật xung quanh mình. Ngoài các sản phẩm gắn với thực tế và một số trò chơi thú vị học sinh hoàn toàn có thể tạo ra những sản phẩm hỗ trợ trong việc học tập các môn học như: Toán, Lý, Hóa, Ngữ Văn,.. Đồng thời thông qua việc thực hành tạo ra các sản phẩm trong cuốn sách các em có thể hiểu được những kiến thức cơ bản về bộ môn lập trình như những kiến thức về vòng lặp, biến, hàm,… một cách dễ dàng, gần gũi nhất.\r\nSau mỗi bài học nội dung kiến thức sẽ được tóm tắt, minh họa bằng những hình ảnh sinh động đi kèm với phần bài tập nhằm củng cố và nâng cao kiến thức học sinh đã được tìm hiểu trong bài học.', 200000, 190, NULL, 0, 0),
('S000009', 'All About Biology', 'Robert Wintons', 'DK Publishing', 2016, 'Sách Khoa Học Công Nghệ', 'Tiếng Anh', 'What makes Earth an ideal place for life to survive? Professor Robert Winston will take kids back to Earth\'s beginnings showing how organisms live and survive in All About Biology. From the very big to the microscopic, meet the animals, plants, fungi and bacteria that play an important role in sustaining life on Earth.\r\n\r\nPacked with colourful images, facts and stats, All About Biology introduces the features and characteristics of the six main kingdoms of life. Help your child discover how life began and just what it means to be alive today.', 297000, 96, NULL, 0, 0),
('S000010', 'Big Data', 'Timandra Harkness', 'Bloomsbury', 2018, 'Sách Công Nghệ Thông Tin', 'Tiếng Anh', 'What is Big Data, and why should you care?\r\n\r\nBig data knows where you\'ve been and who your friends are. It knows what you like and what makes you angry. It can predict what you\'ll buy, where you\'ll be the victim of crime and when you\'ll have a heart attack. Big data knows you better than you know yourself, or so it claims.\r\n\r\nBut how well do you know big data?\r\n\r\nYou\'ve probably seen the phrase in newspaper headlines, at work in a marketing meeting, or on a fitness-tracking gadget. But can you understand it without being a Silicon Valley nerd who writes computer programs for fun?\r\n\r\nYes. Yes, you can.\r\n\r\nTimandra Harkness writes comedy, not computer code. The only programmes she makes are on the radio. If you can read a newspaper you can read this book.\r\n\r\nStarting with the basics - what IS data? And what makes it big? - Timandra takes you on a whirlwind tour of how people are using big data today: from science to smart cities, business to politics, self-quantification to the Internet of Things.\r\n\r\nFinally, she asks the big questions about where it\'s taking us; is it too big for its boots, or does it think too small? Are you a data point or a human being? Will this book be full of rhetorical questions?\r\n\r\nNo. It also contains puns, asides, unlikely stories and engaging people, inspiring feats and thought-provoking dilemmas. Leaving you armed and ready to decide what you think about one of the decade\'s big ideas: big data.\r\n\r\nGiá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Tuy nhiên tuỳ vào từng loại sản phẩm hoặc phương thức, địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, ...', 330000, 320, NULL, 0, 0),
('S000011', 'How Not To Be Wrong: The Hidden Maths Of Ever', 'Jordan Ellenberg', 'Penguin Random House UK', 2015, 'Sách Khoa Học Công Nghệ', 'Tiếng Anh', 'THE SUNDAY TIMES BESTSELLER\r\n\r\nThe maths we learn in school can seem like an abstract set of rules, laid down by the ancients and not to be questioned. In fact, Jordan Ellenberg shows us, maths touches on everything we do, and a little mathematical knowledge reveals the hidden structures that lie beneath the world\'s messy and chaotic surface. In How Not to be Wrong, Ellenberg explores the mathematician\'s method of analyzing life, from the everyday to the cosmic, showing us which numbers to defend, which ones to ignore, and when to change the equation entirely. Along the way, he explains calculus in a single page, describes Gödel\'s theorem using only one-syllable words, and reveals how early you actually need to get to the airport.', 320000, 468, NULL, 0, 0),
('S000012', 'The Wonderful Wizard Of Oz: A Commemorative P', 'Robert Sabuda', 'Simon And Schuster', 2001, 'Sách Thiếu Nhi', 'Tiếng Anh', 'Robert Sabuda has created a resplendent pop-up version of The Wonderful Wizard of Oz to celebrate the 100th anniversary of the original publication. This glorious edition is told in a shorter version of L. Frank Baum\'s original text, with artwork in the style of W. W. Denslow. With sparkling touches of colored foil and Emerald City eyeglasses, this classic tale is certain to find an honored place on the family bookshelf.', 535000, 16, NULL, 0, 0),
('S000013', 'I-Learn Smart Start 2 Student Book', 'Paperback', 'Nhà Xuất Bản Đại Trường Phát', 2016, 'Sách Học Ngoại Ngữ', 'Tiếng Anh', 'Smart Start is a 5-level course for young learners of English. It has been developed by an experienced team of International and Vietnamese writers and teachers to be a perfect fit for the Vietnamese classroom.\r\n\r\n- Solid curriculum\r\n\r\nBased on  the Cambridge Young Learner\'s syllabus and the Vietnamese Ministry of Education and Training (MOET) guidelines.\r\n\r\n- User-friendly lesson format\r\n\r\nClear, consistent, and logical format makes lessons easy to prepare, teach, and understand.\r\n\r\n- Proven, mmotivational materials\r\n\r\nCatchy songs, colorful comic strips, and fun games catch students\' interest.\r\n\r\n- Effective balance of skills\r\n\r\nA level appropriate mix of Listening, Speaking, Reading and Writing tasks to systematically develop student abilities.\r\n\r\n- Knowledge and culture focus\r\n\r\nCore subjects (math, science, geoography, etc.) and moral lessons (be helpful, respect elders, be neat and tidy, etc.) are covered within a Vietnamese cutural setting.\r\n\r\n- Test taking skills\r\n\r\nEach theme includes excercises that familiarize students with the common tasks they will find on exams like the Cambridge Young Learners exams.', 108000, 128, NULL, 0, 0),
('S000014', 'Everybody Up 3 Student\'s Book', 'Susan Banman Sileci', 'Oxford University Press', 2017, 'Sách Học Ngoại Ngữ', 'Tiếng Anh', 'Everybody Up encourages children to use language in a natural and meaningful way by connecting English to their own lives. Colorful cross-curricular lessons link English to other school subjects. Fun stories teach life lessons such as being kind and polite. Great songs, and the special Everybody Up Friends, motivate children to practice English - even at home! ', 265000, 80, NULL, 0, 0),
('S000015', 'Diary Of A Wimpy Kid 01: A Novel In Cartoons', 'Jeff Kinney', 'Penguin Random House', 2008, 'Sách Thiếu Nhi', 'Tiếng Anh', 'The hilarious and original global bestseller Diary of a Wimpy Kid - perfect for readers of 8+ and also reluctant readers, everyone loves the adventures of Greg Heffley. Now a major film series, Diary of a Wimpy Kid: The Long Haul is in cinemas now!\r\n\r\nLet me get something straight: this is a JOURNAL, not a diary. This was Mom\'s idea, not mine. But if she thinks I\'m going to write down my \"feelings\" in here or whatever, she\'s crazy.\r\n\r\nThe only reason I agreed to do this at all is because I figure later on when I\'m rich and famous, this book is gonna come in handy.\r\n\r\nBut for now I\'m stuck with a bunch of morons.\r\n\r\nToday is the first day of school, so I figured I might as well write in this book to pass the time.\r\n\r\nJust don\'t expect me to be all \"Dear Diary\" this and \"Dear Diary\" that.\r\n\r\nPraise for Jeff Kinney:\r\n\r\n\'The world has gone crazy for Jeff Kinney\'s Diary of a Wimpy Kid\' - Sun\r\n\r\n\'Kinney is right up there with J K Rowling as one of the bestselling children\'s authors on the planet\' - Independent\r\n\r\n\'The most hotly anticipated children\'s book of the year is here - Diary of a Wimpy Kid\' - Big Issue\r\n\r\n\'Hilarious\' - Telegraph', 136000, 224, NULL, 0, 0),
('S000016', 'Các Thế Giới Song Song (Tái Bản 2018)', 'Michio Kaku ', 'Nhà Xuất Bản Thế Giới', 2018, 'Sách Khoa Học Công Nghệ', 'Tiếng Việt', 'Một chuyến du hành đầy trí tuệ qua các vũ trụ, được dẫn dắt tài tình bởi \"thuyền trưởng\" Michio Kaku và độc giả có dịp chiêm ngưỡng vẻ đẹp kỳ vĩ của vũ trụ kể từ vụ nổ lớn, vượt qua những hố đen, lỗ sâu, bước vào các thế giới lượng tử từ muôn màu kỳ lạ nằm ngay trước mũi chúng ta, vốn dĩ tồn tại song song trên một màng bên ngoài không - thời gian bốn chiều, ngắm nhìn thực tại vật chất quen thuộc hoà quyện với thế giới của những điều kỳ diệu như năng lượng và vật chất tối, sự nảy chồi của các vũ trụ, những chiều không gian bí ẩn và sự biến ảo của các dây rung siêu nhỏ...\r\n\r\nDẫn chuyện lôi cuốn, kết hợp tường minh, sống động một lượng thông tin đồ sộ để khai mở những giới hạn tột cùng của trí  tưởng tượng, Kaku thực sự xứng đáng là \" nhà truyền giáo\" vĩ đại đã mang thế giới vật lý lý thuyết tới quảng đại quần chúng.', 83000, 480, NULL, 0, 0),
('S000017', 'Toán Học, Một Thiên Tiểu Thuyết', 'Mickael Launay ', 'Nhà Xuất Bản Thế Giới', 2019, 'Sách Khoa Học Công Nghệ', 'Tiếng Việt', 'Hầu hết mọi người đều thích toán, tiếc là họ không biết điều này!\r\n\r\nBởi ai mà chẳng thấy hấp dẫn với những mẩu chuyện kỳ thú về toán: như “giáo phái” toán học kỳ lạ của Pythagoras thời cổ đại hay những cuộc thăm dò hệ mặt trời bằng công cụ toán học đầy kịch tính thời cận đại, hoặc gần đây hơn là sự kiện máy tính AlphaGo giành chiến thắng trước kỳ thủ cờ vây số một thế giới Lee Sedol bằng những nước đi “thần thánh” sử dụng lý thuyết xác suất.\r\n\r\nToán học khai sinh vì lý do hữu dụng, hẳn nhiên. Vào thời tiền sử, người ta nghĩ ra những con số để đếm đàn gia súc, dùng hình học để đo ruộng đất, làm đường sá. Loài home sapiens chúng ta không ngừng tò mò muốn khám phá thế giới tự nhiên xung quanh, nên suốt mấy ngàn năm qua toán học đã tiến lên phía trước với những bước khổng lồ và ngày càng trừu tượng.\r\n\r\nMickael Launay không chỉ cho người đọc thấy cái đẹp, chất thơ của toán học mà còn xác quyết một điều khác, rằng mọi người đều có thể yêu thích toán học và đều có thể cảm nhận được vẻ đẹp tự nhiên của nó. Cuốn sách này là một minh chứng cho điều đó.', 72000, 332, NULL, 0, 0),
('S000018', 'Luyện Nói Tiếng Anh Như Người Bản Ngữ (Tái Bả', 'A.J.Hoge', 'Nhà Xuất Bản Đại Học Quốc Gia Hà Nội', 2015, 'Sách Học Ngoại Ngữ', 'Tiếng Việt', 'Effortless English – Luyện nói tiếng Anh như người bản ngữ – Phương pháp học tiếng Anh nổi tiếng thế giới, kết quả đã được kiểm chứng\r\n\r\nNhững vấn đề sau có đang làm khó các bạn?\r\n\r\nMất cảm hứng, chán nản khi học Tiếng Anh\r\nBạn đã bao lần từ bỏ việc học tiếng Anh vì ngày này qua tháng nọ dường như cứ mãi dậm chân tại chỗ dù đã thử nhiều phương pháp. Học tiếng Anh từ lớp 3 nhưng đến lúc tốt nghiệp đại học trình độ nhiều bạn vẫn chỉ dừng lại ở những câu đơn giản như “hello”, “hi”,…\r\n\r\nCuốn sách gồm 23 chương trong đó có tới 8 chương cung cấp cho người học những quy tắc và bí quyết giúp các bạn có thể nói tiếng Anh thành thạo. Những quy tắc được trình bày dễ hiểu, dễ ghi nhớ và phù hợp với người Việt chúng ta.\r\n\r\n– Quy tắc đầu tiên: Học theo cụm từ – không học đơn lẻ\r\n\r\n– Quy tắc thứ hai: Hoc ngữ pháp sẽ hạn chế khả năng nói của bạn\r\n\r\n– Quy tắc thứ ba: Học bằng tai không phải học bằng mắt\r\n\r\n– Quy tắc thứ tư: Lặp lại là chìa khóa để nắm vững kỹ năng nói tiếng Anh\r\n\r\n– Quy tắc thứ năm: Học ngữ pháp một cách trực quan và tự nhiên\r\n\r\n– Quy tắc thứ sáu: Hãy học tiếng Anh thực tế và tạm bỏ những cuốn giáo trình\r\n\r\n– Quy tắc thứ bảy: Học tiếng Anh với các câu chuyện hấp dẫn\r\n\r\n– Bí quyết để có kỹ năng viết tiếng Anh tốt\r\n\r\nChắc chắn thông qua hệ thống quy tắc và bí quyết này các bạn có thể thay đổi được tư duy nói tiếng Anh một cách khoa học.', 150000, 303, NULL, 0, 0),
('S000019', 'Ngữ Pháp Tiếng Hàn Thông Dụng - Sơ Cấp (Dùng ', 'Ahn Jean-myung', 'Nhà Xuất Bản Hồng Đức', 2015, 'Sách Học Ngoại Ngữ', 'Tiếng Việt', 'Cuốn sách này được thiết kế hoàn toàn phù hợp với những người mới bắt đầu học tiếng Hàn. Sách gồm có 3 phần chính tổng hợp các kiến thức chính về ngữ pháp tiếng Hàn sơ cấp và thêm nhiều phần kiến thức liên quan:\r\n\r\n– Phần 1: Giới thiệu tiếng Hàn Quốc (Phần này sẽ giúp các bạn bước đầu có những hình dung về tiếng Hàn, là tiền đề để bạn học tốt môn ngoại ngữ này)\r\n\r\n– Phần 2: 24 bài học hệ thống các cấu trúc ngữ pháp phù hợp với trình độ của các bạn\r\n\r\n– Phần 3: Phụ lục (Cung cấp thêm nhiều kiến thức bổ trợ và đáp án cho các bài luyện tập ở phía trước)\r\n...', 143000, 379, NULL, 0, 0),
('S000020', '301 Câu Đàm Thoại Tiếng Hoa (Tái Bản)', 'Trần Thanh Liêm', 'Nhà Xuất Bản Hồng Đức', 2018, 'Sách Học Ngoại Ngữ', 'Tiếng Việt', 'Giáo trình \"\"301 câu đàm thoại tiếng Hoa\"\" được biên dịch và bổ sung dựa trên cơ sở cuốn sách giáo khoa \"\" Hán ngữ hội thoại 301\"\" do các chuyên gia Hán ngữ của học viện ngôn ngữ Bắc kinh biên soạn.\r\n\r\nGiáo trình gồm 48 bài trong đó có 8 bài ôn tập, bao quát trên 800 từ thường dùng. Nội dung các bài tập gồm các phần \"\"Mẫu câu\"\", \"\"Đàm thoại\"\", \"\"Từ mới\"\", \"\"Chú ý từ ngữ\"\", \"\"Ngữ pháp\"\", \"\"bài tập\"\"... \r\n\r\nGiáo trình biên soạn theo hướng \"\"mẫu câu\"\" để đi vào thực hành giao tiếp, nhưng cũng giới thiếu khái quát cấu trúc ngữ pháp của tiếng Hán hiện đại.', 44000, 416, NULL, 0, 0),
('S000021', '365 Truyện Kể Hằng Đêm - Mùa Thu', 'Lưu Hồng Hà', 'Nhà Xuất Bản Đại Học Sư Phạm', 2015, 'Sách Thiếu Nhi', 'Tiếng Việt', 'Trẻ nhỏ thường nhận thức thế giới qua những điều đơn giản. Chính vì thế, những quan điểm chuẩn mực về đạo đức của mỗi người thường bắt nguồn từ những câu chuyện nghe kể từ thuở ấu thơ.\r\n\r\nCuốn sách tập hợp những truyện ngụ ngôn, đồng thoại, cổ tích đặc sắc từ xưa đến nay của nhiều quốc gia trên thế giới. Mỗi câu chuyện là một bài học nhỏ với các tình tiết sống động, hấp dẫn. Hy vọng rằng, cuốn sách sẽ trở thành một người bạn gần gũi, thân thiết của các em trong quá trình hình thành những phẩm chất tốt đẹp, tạo nền tảng vững chắc cho sự hình thành nhân cách trong tương lai.', 60000, 190, NULL, 0, 0),
('S000022', 'Vì Chơi Là Học: Dành Cho Trẻ 1 - 2 Tuổi', ' Tadashi Tsujii', 'Nhà Xuất Bản Lao Động', 2016, 'Sách Thiếu Nhi', 'Tiếng Việt', 'Cuốn thứ hai trong bộ sách Vì Chơi Là Học của tác giả Tadashi Tsujii đã gợi ý cho các bậc cha mẹ có con nhỏ từ 1-2 tuổi cách chơi cùng con và những trò chơi nhẹ nhàng, thú vị nhưng mang tính giáo dục cao để cha mẹ có thể hướng dẫn con tự chơi, tự khám phá và hoàn thiện các kỹ năng.\r\n\r\nKhi kết thúc giai đoạn sơ sinh và bước vào giai đoạn tập đi, trẻ có rất nhiều thay đổi trong nhận thức và “ý thức cá nhân”, bởi vậy, cách cha mẹ chơi cùng con và hướng dẫn con chơi cũng cần thay đổi rất nhiều. Vẫn với cách viết nhẹ nhàng, những miêu tả chi tiết kết hợp với hình ảnh minh hoạ sinh động, tác giả đưa ra những “bài tập” chơi phù hợp với từng tháng trong suốt năm tuổi thứ hai của trẻ.\r\n\r\nGiai đoạn trẻ được 1 năm 1 tháng tuổi, việc rèn luyện các kỹ năng tương tác xã hội của trẻ nên được chú trọng. Bằng những trò chơi đơn giản như để bé thấy sự thay đổi biểu cảm hoặc bắt chước hành động hay cách trò chuyện của mẹ, bé sẽ học được cách giao tiếp, ứng xử và phát triển nhận thức về các mối quan hệ. Ngoài ra, mẹ có thể hướng dẫn bé chơi cùng những món đồ chơi yêu thích để rèn luyện sự khéo léo và kỹ năng tổ chức.\r\n\r\nGiai đoạn trẻ được 1 năm 2 tháng tuổi, việc giáo dục trẻ các quy tắc xã hội và ý thức tự lập được đề cao. Trẻ ở giai đoạn này rất thích thú với việc tập đi, khám phá thế giới và tự làm các công việc cá nhân. Cha mẹ nên tạo cho con một môi trường an toàn, thoải mái và hướng dẫn con tự chơi những trò chơi kích thích trí tò mò và rèn luyện khả năng vận động cũng như sự khéo léo của đôi tay.\r\nTrong cuốn thứ hai của bộ sách, tác giả Tadashi Tsujii vẫn nhấn mạnh vai trò của người cha trong việc chơi đùa cùng con. Nếu ở giai đoạn trẻ sơ sinh, vấn đề giới tính chưa hiện lên rõ nét trong hoạt động giao tiếp giữa bố con, thì ở giai đoạn này, bố sẽ có vai trò lớn hơn trong việc ảnh hưởng đến nhận thức về giới tính của con, và các trò chơi của bố có thể khác biệt đối với bé trai và bé gái hoặc tuỳ thuộc vào cá tính của mỗi trẻ.\r\n\r\nMột lần nữa, tác giả Tadashi Tsujii nhắc nhở các bậc cha mẹ rằng học cách chơi đùa cùng con còn cần thiết và quan trọng hơn việc tắm rửa hay những bữa ăn hàng ngày. Một cái cây muốn bền bỉ trước bão tố cần có một bộ rễ vững chắc cắm sâu vào lòng đất. Một đứa trẻ muốn phát triển tốt và vững vàng trước sóng gió cuộc đời cần một nền tảng giáo dục tốt ngay từ những ngày đầu tiên. Và như thế, việc vui chơi không chỉ mang lại niềm vui thích cho trẻ, mà qua đó, trẻ sẽ khám phá ra nhiều điều về thế giới xung quanh, hình thành các kỹ năng, xây dựng tính cách và hoàn thiện nhân cách. Nếu cha mẹ biết cách chơi mà học cùng con, trẻ sẽ có nền tảng tốt để vươn cao và vững vàng trước cuộc đời.', 43000, 143, NULL, 0, 0),
('S000023', 'Cẩm Nang Dành Cho Trẻ Em - Khi Trẻ Mắc Những ', 'Dawn Huebner ', 'Nhà Xuất Bản Phụ Nữ', 2013, 'Sách Thiếu Nhi', 'Tiếng Việt', 'Làm sao để con có một hành trình trưởng thành thuận lợi là điều mà mọi cha mẹ đều mong ước. Trong thực tế, sự phát triển của mỗi trẻ em hầu như rất khác nhau và không phải lúc nào cũng suôn sẻ. Nhiều trẻ gặp phải một hoặc nhiều khó khăn riêng gây ra những rào cản trong cuộc sống thường nhật làm ảnh hưởng tới bản thân, gia đình và các mối quan hệ xã hội. Ở độ tuổi từ 6 -12, trẻ thường có xu hướng mắc phải một số thói quen và suy nghĩ tiêu cực, gây ra không ít rào cản trong học tập và sinh hoạt. Là một nhà tâm lý có bề dày kinh nghiệm của Mỹ, tiến sĩ Dawn Huebner đã viết ra bộ sách What-to-do Guides for Kids - Cẩm nang dành cho trẻ em, hướng dẫn cha mẹ tương tác cùng với con cái để các em có một hành trình trưởng thành thuận lợi hơn, hạnh phúc hơn.\r\n\r\nBộ sách gồm 6 cuốn, là 6 giải pháp cho các vấn đề mà trẻ thường hay gặp: quá lo lắng, khó ngủ một mình, dễ nóng giận, có các thói quen xấu khó bỏ (như mút tay, cắn móng tay, nhai áo, gãi da, xoắn tóc…), hội chứng ám ảnh cưỡng chế (OCD), hay than phiền…\r\n\r\nNhững đứa trẻ dễ nổi giận hẳn sẽ làm cho cha mẹ lo lắng, thậm chí nhiều người cảm thấy bất lực trong việc giúp con mình sửa chữa thói tật này. Trong cuốn Khi cơn giận của trẻ bùng nổ, tác giả khuyến khích trẻ dùng trí tưởng tượng đầy sáng tạo để giúp chế ngự cơn giận, làm chủ cảm xúc.\r\n\r\nKhi trẻ quá lo lắng là cuốn sách giúp trẻ thoát khỏi những lo lắng bằng những mẹo rất thú vị, như viết hoặc vẽ ra nỗi lo lắng, cãi lại lo âu trong đầu, giảm thời gian lo lắng lại bằng cách tạo một chiếc hộp tưởng tượng để “nhốt” các lo lắng vào đó cho đến các mẹo thư giãn tâm trí và cơ thể…\r\n\r\nKhi trẻ mắc những thói quen xấu chỉ ra rằng những thói quen xấu hình thành và khóa chặt vào trẻ. Cuốn sách “trao” cho trẻ chùm chìa khóa 5 chiếc, mỗi chiếc có một tính năng riêng có thể giúp giải phóng khỏi các thói quen không tốt mà trẻ vô tình bị chúng khống chế.\r\n\r\nRất nhiều cha mẹ bất lực trong việc tìm cách giúp trẻ có thói quen tự ngủ một mình. Cuốn sách Khi trẻ sợ chiếc giường ngủ sẽ bày cho trẻ những “thủ thuật” có thể vượt qua những rắc rối về giấc ngủ để một mình ngon giấc suốt đêm.\r\n\r\nKhi não của trẻ gặp rắc rối là một cách thức giúp các bậc cha mẹ đồng hành với con chống lại chứng rối loạn ám ảnh cưỡng chế (OCD - Obsessive - Compulsive   Disorder). Tác phẩm được viết bằng văn phong giản dị, vừa dí dỏm vừa mộc mạc, phù hợp với tư duy của con trẻ mà không mất đi tính khoa học vốn có của vấn đề. Độc giả nhí dễ dàng bị cuốn theo những tình huống ấn tượng, những bài tập thực hành đầy thú vị, từ đó thay đổi suy nghĩ và hành vi theo hướng tích cực…\r\n\r\nCuốn Khi trẻ than phiền quá nhiều giúp trẻ loại bỏ những “than phiền tiêu cực”, chuyển sang cách suy nghĩ tích cực. Vấn đề này sẽ được giải quyết một cách hết sức linh hoạt, qua việc trẻ trò chuyện cùng tác giả - với vai trò một người bạn - và làm những bài tập giống như những trò chơi thú vị, từ đó học được lối suy nghĩ lạc quan.\r\n\r\nBằng cách đặt vấn đề rất đơn giản nhưng thiết thực và gần gũi, tác giả đã dẫn dắt các câu chuyện thật hấp dẫn, linh hoạt để các độc giả nhí khám phá những bí quyết giúp thay đổi bản thân theo chiều hướng tích cực hơn. Sách không chỉ phù hợp với tâm lí của trẻ em mà còn rất thuyết phục các bậc làm cha mẹ.\r\n\r\nBộ sách được Hiệp Hội Tâm lý học Hoa Kỳ xuất bản và giới thiệu, là tài liệu cần thiết cho các phụ huynh, giáo viên và các nhà tâm lý. Sách đoạt nhiều giải thưởng danh giá tại Hoa Kỳ như iParenting Media Award, Young Voices Award, National Parenting Publications Awards, The Mom’s Choice Awards….', 57000, 96, NULL, 0, 0),
('S000024', 'Tủ Sách Cha Mẹ Giỏi, Con Thông Minh - Dạy Con', 'Phúc Lai', 'Nhà Xuất Bản Văn Học', 2007, 'Sách Thiếu Nhi', 'Tiếng Việt', 'Cuốn sách được viết bởi một ông bố, qua những cuộc đối thoại với con để làm bạn với con, để dạy con cũng như dạy chính mình.\r\n\r\n\"Con chúng ta có thể không phải là thiên tài nhưng chúng hoàn toàn có thể là những người tốt” chỉ cần chúng ta biết trò chuyện với chúng.\r\n\r\n\"Với trẻ con, thì khái niệm sở hữu được làm quen dần dần, \"Nhi Bá có cái gì đó\" cũng như “Nhi Bá không có cái gì đó\", đều quan trọng như nhau. Con trai ạ, rồi con sẽ còn phải hiểu cái gì không có thì sẽ làm như thế nào để có được, lại còn phải hiểu, mong cầu ít thôi, biết thế nào là đủ với mình; mong cầu mà không đạt được, là khổ lắm đấy con à…\" – Phúc Lai', 48000, 248, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `lydophat`
--

CREATE TABLE `lydophat` (
  `maLDPhat` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenLDPhat` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mucDo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNCC` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenNCC` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNhanVien` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password_hashed` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RFID_code` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hoTen` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(65) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `chucVu` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`maNhanVien`, `password`, `password_hashed`, `RFID_code`, `hoTen`, `ngaySinh`, `diaChi`, `sdt`, `email`, `chucVu`) VALUES
('QL000001', 'QL000001', NULL, NULL, 'Nguyễn Mai Ngọc Bích', '1988-11-02', 'Cao Thắng, Quận 3, TP HCM', '0358990124', 'ngocbich@gmail.com', 'Thủ Thư'),
('QL000002', 'QL000002', NULL, NULL, 'Nguyễn Đức Minh', '1985-02-13', 'Hồ Học Lãm, Quận Bình Tân, TP HCM', '0705145202', 'minhnguyen@gmail.com', 'Quản Lý Kho'),
('QL000003', 'QL000003', NULL, NULL, 'Lê Vân Nhi', '1992-07-17', '3 Tháng 2, Quận 10, TP HCM', '0903214760', 'vannhi@gmail.com', 'Thủ Thư'),
('QL000004', 'QL000004', NULL, NULL, 'Lê Gia An', '1987-10-20', 'Lê Lợi, Quận 1, TP HCM', '0345905191', 'anle@gmail.com', 'Quản Lý Kho'),
('QL000005', 'QL000005', NULL, NULL, 'Phạm Ánh Dương', '1994-03-15', 'Nguyễn Công Trứ, Quận Bình Thạnh, TP HCM', '0935120275', 'anhduong@gmail.com', 'Thủ Thư'),
('QL000006', 'QL000006', NULL, NULL, 'Phạm Thiên Ân', '1990-01-31', 'Phan Văn Hớn, Huyện Hóc Môn, TP HCM', '0950123589', 'anhpham@gmail.com', 'Quản Lý Kho'),
('QL000007', 'QL000007', NULL, NULL, 'Đặng Gia Hân', '1993-05-29', 'Huỳnh Văn Nghệ, Quận Gò Vấp, TP HCM', '0795342467', 'giahan@gmail.com', 'Thủ Thư'),
('QL000008', 'QL000008', NULL, NULL, 'Đặng Ngọc Gia Nguyên', '1986-08-20', 'Nguyễn Văn Trỗi, Quận Phú Nhuận, TP HCM', '0940567316', 'nguyendang@gmail.com', 'Quản Lý Kho'),
('QL000009', 'QL000009', NULL, NULL, 'Đỗ Phương Thảo', '1995-10-10', 'Bạch Đằng, Quận Tân Bình, TP HCM', '0775428796', 'phuongthao@gmail.com', 'Thủ Thư'),
('QL000010', 'QL000010', NULL, NULL, 'Đỗ Quang Khải', '1986-12-24', 'Phan Châu Trinh, Quận Tân Phú, TP HCM', '0902464703', 'khaido@gmail.com', 'Quản Lý Kho');

-- --------------------------------------------------------

--
-- Table structure for table `phieumuon`
--

CREATE TABLE `phieumuon` (
  `maPhieuMuon` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `maThe` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `ngayMuon` date NOT NULL,
  `thoiGianMuon` int(11) NOT NULL,
  `ngayTra` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieumuon`
--

INSERT INTO `phieumuon` (`maPhieuMuon`, `maThe`, `ngayMuon`, `thoiGianMuon`, `ngayTra`) VALUES
('M000001', 'T000001', '2020-01-10', 4, NULL),
('M000002', 'T000002', '2020-01-25', 17, NULL),
('M000003', 'T000003', '2020-02-04', 7, NULL),
('M000004', 'T000003', '2020-02-12', 20, NULL),
('M000005', 'T000004', '2020-02-05', 15, NULL),
('M000006', 'T000004', '2020-02-05', 15, NULL),
('M000007', 'T000005', '2020-02-03', 12, NULL),
('M000008', 'T000006', '2020-02-08', 8, NULL),
('M000009', 'T000006', '2020-02-08', 8, NULL),
('M000010', 'T000007', '2020-02-28', 3, NULL),
('M000011', 'T000008', '2020-03-14', 5, NULL),
('M000012', 'T000009', '2020-03-20', 9, NULL),
('M000013', 'T000010', '2020-04-03', 10, NULL),
('M000014', 'T000011', '2020-04-08', 16, NULL),
('M000015', 'T000012', '2020-04-16', 3, NULL),
('M000016', 'T000013', '2020-04-18', 11, NULL),
('M000017', 'T000014', '2020-04-21', 2, NULL),
('M000018', 'T000015', '2020-05-02', 14, NULL),
('M000019', 'T000015', '2020-05-02', 14, NULL),
('M000020', 'T000016', '2020-05-09', 4, NULL),
('M000021', 'T000017', '2020-05-11', 6, NULL),
('M000022', 'T000018', '2020-05-21', 5, NULL),
('M000023', 'T000019', '2020-06-02', 7, NULL),
('M000024', 'T000020', '2020-06-07', 5, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maNhap` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `ngayNhap` date NOT NULL,
  `maQuanLy` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `maNCC` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `tongSoLuong` int(11) NOT NULL,
  `tongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieuphat`
--

CREATE TABLE `phieuphat` (
  `maPhieuPhat` varchar(7) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `maPhieuMuon` varchar(7) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tienPhat` int(11) NOT NULL,
  `maLDPhat` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maXuat` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `ngayXuat` date NOT NULL,
  `maQuanLy` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `tongSoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `the`
--

CREATE TABLE `the` (
  `maThe` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `maKhachhang` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngayCap` date NOT NULL,
  `ngayHetHan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `the`
--

INSERT INTO `the` (`maThe`, `maKhachhang`, `ngayCap`, `ngayHetHan`) VALUES
('T000001', 'KH000001', '2020-01-08', '2021-01-08'),
('T000002', 'KH000002', '2020-01-15', '2021-01-15'),
('T000003', 'KH000003', '2020-01-21', '2021-01-21'),
('T000004', 'KH000004', '2020-01-30', '2021-01-30'),
('T000005', 'KH000005', '2020-02-02', '2021-02-02'),
('T000006', 'KH000006', '2020-02-06', '2021-02-06'),
('T000007', 'KH000007', '2020-02-27', '2021-02-27'),
('T000008', 'KH000008', '2020-03-04', '2021-03-04'),
('T000009', 'KH000009', '2020-03-14', '2021-03-14'),
('T000010', 'KH000010', '2020-03-20', '2021-03-20'),
('T000011', 'KH000011', '2020-03-29', '2021-03-29'),
('T000012', 'KH000012', '2020-04-14', '2021-04-14'),
('T000013', 'KH000013', '2020-04-16', '2021-04-16'),
('T000014', 'KH000014', '2020-04-18', '2021-04-18'),
('T000015', 'KH000015', '2020-04-28', '2021-04-28'),
('T000016', 'KH000016', '2020-05-03', '2021-05-03'),
('T000017', 'KH000017', '2020-05-09', '2021-05-09'),
('T000018', 'KH000018', '2020-05-19', '2021-05-19'),
('T000019', 'KH000019', '2020-05-31', '2021-05-31'),
('T000020', 'KH000020', '2020-06-06', '2021-06-06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`tkAdmin`);

--
-- Indexes for table `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD KEY `FK_MaPhieuMuon_ChiTietPhieuMuon` (`maPhieuMuon`),
  ADD KEY `FK_IDSach_ChiTietPhieuMuon` (`IDSach`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `FK_MaSach_NK` (`maSach`),
  ADD KEY `FK_MaNhap` (`maNhap`);

--
-- Indexes for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD KEY `FK_MaSach_XuatKho` (`maSach`) USING BTREE,
  ADD KEY `FK_MaXuat` (`maXuat`);

--
-- Indexes for table `chitietsach`
--
ALTER TABLE `chitietsach`
  ADD PRIMARY KEY (`IDSach`),
  ADD KEY `FK_maSach_2` (`maSach`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`maKhachHang`),
  ADD KEY `FK_maThe` (`maThe`);

--
-- Indexes for table `khosach`
--
ALTER TABLE `khosach`
  ADD KEY `FK_maSach` (`maSach`);

--
-- Indexes for table `loaisach`
--
ALTER TABLE `loaisach`
  ADD PRIMARY KEY (`maSach`);

--
-- Indexes for table `lydophat`
--
ALTER TABLE `lydophat`
  ADD PRIMARY KEY (`maLDPhat`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`maNhanVien`);

--
-- Indexes for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`maPhieuMuon`),
  ADD KEY `FK_maThe_2` (`maThe`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maNhap`),
  ADD KEY `FK_MaQuanLy-NhapKho` (`maQuanLy`),
  ADD KEY `FK_NCC-NhapKho` (`maNCC`);

--
-- Indexes for table `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD PRIMARY KEY (`maPhieuPhat`),
  ADD KEY `FK_MaMuonSach` (`maPhieuMuon`),
  ADD KEY `FK_maLDPhat_PhieuPhat` (`maLDPhat`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maXuat`),
  ADD KEY `FK_MaQuanLy-XuatKho` (`maQuanLy`);

--
-- Indexes for table `the`
--
ALTER TABLE `the`
  ADD PRIMARY KEY (`maThe`),
  ADD KEY `FK_maKhachHang` (`maKhachhang`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `FK_IDSach_ChiTietPhieuMuon` FOREIGN KEY (`IDSach`) REFERENCES `chitietsach` (`IDSach`),
  ADD CONSTRAINT `FK_MaPhieuMuon_ChiTietPhieuMuon` FOREIGN KEY (`maPhieuMuon`) REFERENCES `phieumuon` (`maPhieuMuon`);

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_MaNhap` FOREIGN KEY (`maNhap`) REFERENCES `phieunhap` (`maNhap`),
  ADD CONSTRAINT `FK_MaSach_NK` FOREIGN KEY (`maSach`) REFERENCES `loaisach` (`maSach`);

--
-- Constraints for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `FK_MaSach_NhapKho` FOREIGN KEY (`maSach`) REFERENCES `loaisach` (`maSach`),
  ADD CONSTRAINT `FK_MaXuat` FOREIGN KEY (`maXuat`) REFERENCES `phieuxuat` (`maXuat`);

--
-- Constraints for table `chitietsach`
--
ALTER TABLE `chitietsach`
  ADD CONSTRAINT `FK_maSach_2` FOREIGN KEY (`maSach`) REFERENCES `loaisach` (`maSach`);

--
-- Constraints for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `FK_maThe` FOREIGN KEY (`maThe`) REFERENCES `the` (`maThe`);

--
-- Constraints for table `khosach`
--
ALTER TABLE `khosach`
  ADD CONSTRAINT `FK_maSach` FOREIGN KEY (`maSach`) REFERENCES `loaisach` (`maSach`);

--
-- Constraints for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `FK_maThe_2` FOREIGN KEY (`maThe`) REFERENCES `the` (`maThe`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_MaQuanLy-NhapKho` FOREIGN KEY (`maQuanLy`) REFERENCES `nhanvien` (`maNhanVien`),
  ADD CONSTRAINT `FK_NCC-NhapKho` FOREIGN KEY (`maNCC`) REFERENCES `nhacungcap` (`maNCC`);

--
-- Constraints for table `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD CONSTRAINT `FK_MaMuonSach` FOREIGN KEY (`maPhieuMuon`) REFERENCES `phieumuon` (`maPhieuMuon`),
  ADD CONSTRAINT `FK_maLDPhat_PhieuPhat` FOREIGN KEY (`maLDPhat`) REFERENCES `lydophat` (`maLDPhat`);

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_MaQuanLy-XuatKho` FOREIGN KEY (`maQuanLy`) REFERENCES `nhanvien` (`maNhanVien`);

--
-- Constraints for table `the`
--
ALTER TABLE `the`
  ADD CONSTRAINT `FK_maKhachHang` FOREIGN KEY (`maKhachhang`) REFERENCES `khachhang` (`maKhachHang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
