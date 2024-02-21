# Spring Boot Project
스프링 부트 프로젝트


## 프로젝트 소개
스프링 시큐리티를 공부하기 위해 만든 쇼핑몰 프로젝트

## 개발환경
- 'Java 17'
- 'Spring Boot 3.2.1'
- **IDE** : Intellli J
- **Database** : MySQL
- **ORM** : JPA
- **Dependency** : Spring JDBC, Spring JPA, Spring web, Spring security, thymeleaf, p6spy

## 주요 기능
#### Security
1. 사용자 권한에 따른 페이지 허용 or 거부
2. 커스텀 로그인 페이지 적용
3. 로그인 성공 시 요청페이지로 이동 (커스텀 로그인 성공 핸들러 적용)
4. security 제공 로그아웃 기능 사용
5. security 제공 csrf 토큰 사용

## 고칠점
1. RestAPI 를 사용 시 csrf 토큰에서 jwt 토큰으로 변경
2. 미구현 기능 다수 ( ex. 아이템 등록, 상품 구매...)
