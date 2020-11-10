package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Entity.FoodBillDetail;
import com.Entity.Ticket;
import com.Entity.TicketDetail;
import com.Services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender emailSender;
	
	@Override
	public void sendMail(String to, String subject, Ticket ticket) {
//		List<String> listSeat = new ArrayList<>();
//		List<TicketDetail> lisTicketDetails = ticket.getTicketDetail();
//		if (ticket.getTicketDetail().size() != 0) {
//			for (TicketDetail ticketDetail : lisTicketDetails) {
//				listSeat.add(ticketDetail.getSeat().getSeatName());
//			}
//		}
//		List<String> listFood = new ArrayList<>();
//		if (ticket.getFoodBillDetail().size() != 0) {
//			List<FoodBillDetail> listFoodBillDetails = ticket.getFoodBillDetail();
//			
//			for (FoodBillDetail foodBillDetail : listFoodBillDetails) {
//				String food = foodBillDetail.getFood().getName() + " (Số lượng: " + foodBillDetail.getQuantity() + ")";
//				listFood.add(food);
//			}
//		}
		String text = "\"Đây là mã code của quý khách:" + ticket.getCode()
				+"\nThông tin vé: "
				+"\n	Số lượng vé: " + ticket.getTicketQuantity()
				+"\n	Tên phim: " + ticket.getShowtimes().getMovie().getMovieName()
				+"\n	Giờ chiếu: " + ticket.getShowtimes().getPeriod().getStartTime()
				+"\n	Tên rạp: " + ticket.getShowtimes().getRoom().getCinema().getName()
				+"\n	Tên phòng: " + ticket.getShowtimes().getRoom().getRoomName()
//				+"\n	Số ghế: " + listSeat
//				+"\n	Đồ ăn, nước uống: " + listFood
				+"\n	Ngày chiếu: " + ticket.getShowtimes().getDate()
				+"\n	Tổng tiền: " + ticket.getTotal()
				+"\nCám ơn quý khách, chúc quý khách xem phim vui vẻ";
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("HaiSaCinema@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
	}
}
