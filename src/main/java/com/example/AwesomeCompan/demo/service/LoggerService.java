package com.example.AwesomeCompan.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class LoggerService {
    public final Logger log = LoggerFactory.getLogger(this.getClass());
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
}
