package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHnadler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(BrokerException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler1(BrokerException ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler2(NoHandlerFoundException ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler3(MethodArgumentNotValidException ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler4(CustomerException ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(StockException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler5(StockException ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ConsolidatedException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler6(ConsolidatedException ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler7(TransactionException ae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMsg(ae.getMessage());
		ed.setDetails(req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		
	}
}
