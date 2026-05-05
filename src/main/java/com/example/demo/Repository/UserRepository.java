package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.UserEntity;

@Repository  // يساعد Spring على اكتشاف هذا الـ Repository تلقائياً
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    // ✅ لا تكتب أي كود هنا!
    // ✅ JpaRepository يمنحك تلقائياً أكثر من 15 دالة جاهزة
}