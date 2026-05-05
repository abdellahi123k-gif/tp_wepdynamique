package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.LivreEntity;

@Repository  // يساعد Spring على اكتشاف هذا الـ Repository تلقائياً
interface LivreRepository extends JpaRepository<LivreEntity, Long> {

    // ✅ لا تكتب أي كود هنا!
    // ✅ JpaRepository يمنحك تلقائياً أكثر من 15 دالة جاهزة
}