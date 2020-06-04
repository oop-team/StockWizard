# Công việc phân công theo tuần

## Tuần 2 
- Lớp tiện ích:
+ Đếm số mã tăng, giảm, đứng giá, không giao dịch => Nhật
	input: Data
	output: số mã tăng, giảm, đứng giá, không giao dịch

	- Tăng giảm:
		+ Theo ngày
		+ Theo tuần
		+ Theo tháng
		+ Theo quý
		+ Theo năm
	...

+ Phân loại các nhóm cổ phiếu (VN-Index, HNX-Index, Blue-chip, ...) => Hiếu
	input: ví dụ "VN-30", 
	output: Data tương ứng

+ Phân loại nhóm ngành cổ phiếu (Dầu khí, bất động sản, Tài chính, Viễn thông, ...) => Đạt
	input: ví dụ "Dầu khí"
	output: Data tương ứng

+ Tên doanh nghiệp ứng với mã cổ phiếu => Tân
	input: ví dụ "ACB"
	output: Ngân hàng TMCP Á Châu

+ Phân loại nến (dựa vào open,close,high,low) => Hùng
	input: ví dụ: (open,close,high,low) = (10, 12, 12, 3)
	output: Hammer (nến búa)


### Ví dụ mẫu câu

- Nhóm ngành
"Chỉ số VnIndex giảm 8% trong 3 tháng"


- Hình nến:
+ Các loại nến
    + "HN-Index hôm nay giao dịch tạo thành cây nến Hammer. Một tín hiệu cảnh báo sự đảo chiều ngắn hạn."
    + "VN-Index tăng điểm khá nhẹ nhàng và thiết lập mức cao mới tại 821 điểm với nến marobuzu không có bóng nến."
    + "Xác suất tăng giảm giá ngày mai: 43%/55% (Dựa theo thống kê lịch sử của mẫu thình nến)."

- Nhóm cổ phiếu: VN-Index, HNX-Index, Blue-chip,...
+ "Bên sàn Hà Nội, HNX-Index lùi dần về mốc 60"


- Nhóm ngành:
+ Dầu khí
Trên sàn Upcom, những mã dầu khí như OIL, BSR đồng loạt giảm sâu trong phiên hôm nay.


- Đánh giá chung:
"so với cục diện tuần trước thì tuần này thị trường kém tích cực hơn."

## Tuần 3

- Nhật: 
    + Hoàn thiện lớp tiện ích Counter (gấp)
    + Làm 4 câu liên quan (sửa lại 3 câu đã có, dùng lớp tiện ích + thêm 1 câu)

- Hiếu:
    + Hoàn thành lớp tiện ích Filter (gấp)
    + Làm 3 câu liên quan
    
- Tân:
    + Hoàn thành lớp tiện ích Dictionary (tên doanh nghiệp ứng với mã cp) (gấp)
    + Làm 3 câu liên quan
    
- Đạt:
    + Làm 3 câu liên quan

- Hùng: 
    + Hoàn thành lớp tiện ích CandleStick
    
- Cao:
    + Nghiên cứu cách crawl data 
        + Toàn cảnh thị trường
        + để update dữ liệu cho lớp Dictionary
        
- Các mẫu câu tham khảo:
1.	Số mã tăng trần vẫn chiếm áp đảo.
2.	Toàn thị trường hiện đang có 97 mã tăng giá, 33 mã giảm giá và 11 mã đứng giá.
3.	Hiện hầu hết các mã đều đứng giá, có 48 mã tăng và 86 mã giảm.
4.	Thị trường đang có 153 mã tăng giá, 10 mã giảm giá và 3 mã chưa có giao dịch.
5.	Thị trường có 87 mã tăng giá, 148 chứng khoán còn lại đều giảm giá, trong đó 127 mã có mức giảm trên 10%, 12 mã có mức giảm trên 20%.
6.	Trên sàn HNX, số mã tăng trần vẫn chiếm áp đảo
7.	Top 10 cổ phiếu có mức vốn hoá tiếp tục có 8/10 mã tăng kịch trần trong đợt 1.
8.	Nhóm VN-30 tuy có số mã giảm nhiều hơn mã tăng nhưng chốt phiên vẫn ghi nhận sắc xanh.
9.	Rổ VN30 đóng cửa chỉ có 5 mã tăng và 7 mã tham chiếu, còn lại là giảm.
10.	Nhóm VN30 có 2 mã tăng giá là PVT và HPG so với 25 mã giảm giá.
11.	Có hơn 80 mã tăng – gấp đôi số giảm, còn lại hơn 260 mã đứng giá.
12.	Tính chung cả 2 sàn có 154 mã giảm giá, tuy nhiên, hầu hết đều có mức giảm dưới 5%.
13.	Các mã Bluechips sàn HNX hầu hết là đứng giá, duy chỉ có SHB giảm 0.2 ngàn đồng (-2.5%).
14.	Thống kê thậm chí cho thấy số mã giảm có nhỉnh hơn đôi chút với 226 mã giảm/182 mã tăng.
15.	Trên HoSE, GAS tăng điểm sau cú “sốc giá” hồi tháng 11.
16.	VCS đã tăng giá ngay từ đầu phiên và đóng cửa tăng 8,7%.
17.	Trong tháng qua, giá cổ phiếu PAC đã tăng 25%.
18.	Chỉ có 2 mã giảm trong tháng qua là HGM giảm 11,1% và SGC giảm 31,6%.

## Tuần 4
Tiếp tục hoàn thành công việc của tuần 3

## Tuần 5
- Bao gồm các công việc chưa hoàn thành của tuần trước
    + Hiếu: Thiếu 2 mô-đun
    + Đạt: Thiếu 2 mô-đun
    + Cao: Chưa xử lí auto-update
    
- Thêm các công việc của tuần này:
    + Nhật: Thêm 2 mô-đun
    + Hiếu: Thêm 2 mô-đun
    + Đạt: Thêm 2 mô-đun
    + Tân: Thêm 2 mô-đun
    + Cao: Thêm 1 mô-đun và làm tính năng save lại result dưới file text.
    + Hùng: Tinh chỉnh lại GUI, test để tìm và sửa các lỗi lặt vặt. Ví dụ như chọn file không đúng, chưa chọn file đã nhấn update.
    Next rồi back lại ko lưu data. Đặt lại kích thước cho hợp lý. Ở phần result, thêm gạch đầu dòng hoặc xuống dòng để tách biệt các câu.
    
- Mẫu câu về nến:
    + Có 8 rising window tăng trong 50 cây nến.
    + chỉ số VN-Idex xuất hiện mô hình nến Shooting Star và các chỉ báo xung lượng giảm dần từ vùng quá mua cho thấy đồ thị giá có thể 
    sẽ điều chỉnh trong tuần giao dịch tới đặc biệt với nhóm cổ phiếu đã tăng mạnh là nhóm blue-chips như VIC, VCB, HPG, BVH...
    + Hiện tại VN30 Index trên thị trường cơ sở đã thể hiện trạng thái tiêu cực quá mức trong những phiên giao dịch trước đó tuy nhiên vào 
    cuối phiên ngày hôm nay yếu tố mẫu nến Dragonfly Doji xuất hiện cho thấy nhà đầu tư vẫn đang kỳ vọng vào kịch bản hồi phục sớm trở lại 
    của VN30 Index trong thời gian tới đây.
    + Gần đây, VN-Index cũng thường hụt cầu ở mức giá xanh dù phiên trước có tín hiệu đảo chiều của nến.
    + VN-Index tăng điểm khá nhẹ nhàng và thiết lập mức cao mới tại 821 điểm với nến marobuzu không có bóng nến.
    + Chỉ số HNX-Index thiết lập cột nến có bóng dưới dài, cho thấy sự phục hồi đáng kể từ mức thấp nhất.
    + HNX-Index một lần nữa bị bán mạnh vào cuối giờ và xuất hiện mẫu hình nến giảm giá “Gravestone Doji”.
    + VN-Index hôm nay giao dịch tạo thành cây nến ngắn màu đỏ giống với mẫu nến Doji.