package com.moon.jakjumbank2.hakjumbank2.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Dao 역할을 대신하게됨
// 인터페이스를 만들고 Entity타입, PK타입을 상속받으면 됨
// Repository랑 Entity는 매우 가까운 관계이므로 함께 두기
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT p FROM Posts p WHERE p.category = '가격비교' ORDER BY p.id DESC")
    List<Posts> findComparisonDesc();

    @Query("SELECT p FROM Posts p WHERE p.category = '교육원후기' ORDER BY p.id DESC")
    List<Posts> findReviewsDesc();
}
