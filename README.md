# ☕ SSAFY Backend Practice (Servlet & JSP)

> **SSAFY 백엔드 과정 - 웹 기초, Servlet, JSP, MVC 패턴 및 데이터베이스 연동 실습 아카이브**  
> 웹 애플리케이션의 핵심 동작 원리를 이해하고, 순수 서블릿부터 단계별 MVC 아키텍처까지 구현하며 백엔드 기초 역량을 다집니다.

<br/>

<div align="center">

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20Servlet-6.x-F80000?style=for-the-badge&logo=jakartaee&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10.1+-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse%20IDE-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

</div>

<br/>

---

## 📌 1. 프로젝트 소개 & 목표

본 저장소는 **SSAFY(삼성청년SW아카데미) 백엔드 과정** 중 Servlet & JSP 기술을 중심으로 웹 프로그래밍의 기초부터 심화까지 단계별로 실습하고 기록하는 레포지토리입니다.

- **HTTP 프로토콜 및 웹 서버 동작 원리 이해**: 클라이언트 요청(Request)과 서버 응답(Response)의 흐름 파악
- **Servlet LifeCycle 학습**: `init()` → `service()` (`doGet()`, `doPost()`) → `destroy()` 라이프사이클 관리
- **웹 컴포넌트 활용**: `Filter`, `Listener`, `Session / Cookie`, `Forward & Redirect` 흐름 제어
- **MVC 패턴 구조화**: Model(Service, DAO, DTO), View(JSP), Controller(Servlet) 분리를 통한 유지보수성 높은 아키텍처 학습
- **JDBC & Database 연동**: MySQL/DB와의 연동을 통한 비즈니스 데이터 CRUD 구현

<br/>

---

## 🛠 2. 개발 환경 & 기술 스택

| 분류 | 기술 / 도구 | 버전 및 상세 |
| :--- | :--- | :--- |
| **Language** | Java | OpenJDK 21 |
| **Web Spec** | Jakarta EE | Jakarta Servlet 6.1.0 / JSP API 4.0.0 |
| **WAS** | Apache Tomcat | 10.1+ (Jakarta EE 10 대응) |
| **Build Tool** | Apache Maven | Project Object Model (`pom.xml`) 의존성 관리 |
| **IDE** | Eclipse / STS | Enterprise Java and Web Developer Tools |
| **VCS** | Git / GitHub | 버전 관리 및 원격 코드 백업 |

<br/>

---

## 📂 3. 프로젝트 구조 (Directory Structure)

각 실습 과제 및 모듈은 독립적인 웹 프로젝트 단위로 구성되어 관리됩니다.

```text
back_servlet/
├── 2132/                     # [WS 02] 영화 관리 서블릿 및 DTO 실습 (Maven/Servlet 환경)
├── 3174/                     # [WS 01-b] 서블릿 생성 및 web.xml / @WebServlet 등록 실습
│   ├── src/main/java/        # 서블릿 컨트롤러 및 Java 소스
│   ├── src/main/webapp/      # web.xml, index.html 및 웹 리소스
│   └── pom.xml               # Maven 의존성 설정
├── 3175/                     # [WS 01-c] 서블릿 생명주기 및 GET/POST 요청 분기 실습
│   ├── src/main/java/        # 서블릿 생명주기 메서드 및 요청 처리 로직
│   ├── src/main/webapp/      # 요청 폼 및 응답 웹 페이지
│   └── pom.xml
├── BE_01/                    # 서블릿 기본 Dynamic Web Project 구조 실습
├── BE_01_maven/              # Maven 기반 Servlet 기본 환경 설정 및 실행
├── BE_03_lab/                # Servlet LifeCycle, Filter, Listener, ControllerHelper(forward/redirect) 및 구구단 실습
├── BE_04_lab/                # EL/JSTL, Filter/Listener, 회원 관리(Member) Controller 및 View 연동 실습
├── Backend_Example/          # [모의 실습] 자동차 관리 시스템 실습 프로젝트 (로그인, 차량 등록 및 목록 조회)
├── Backend_Example_sol/      # [풀이/솔루션] 자동차 관리 시스템 완성 솔루션 (쿠키 Remember-Me, 세션 인증 처리)
├── backend-servlet/          # 백엔드 서블릿 종합 실습 및 공통 모듈
├── servlet_jsp/              # Servlet & JSP 연계 기초 실습
├── Servers/                  # Eclipse 로컬 Tomcat 서버 구성 파일
├── .gitignore                # Git 제외 파일 설정
└── README.md                 # 프로젝트 문서
```

<br/>

---

## 📋 4. 실습 진행 현황 (Progress Tracker)

> 단계별 실습 과제(Workshop / Homework / Lab)의 진행 상황을 기록합니다.

| 차수 / 번호 | 프로젝트명 | 학습 주제 및 핵심 내용 | 상태 |
| :---: | :--- | :--- | :---: |
| **3174** | `WS 01-b` | • 서블릿 기본 생성 및 매핑<br/>• `web.xml` 배포 서술자 등록 및 `@WebServlet` 어노테이션 매핑 실습 | ✅ 완료 |
| **3175** | `WS 01-c` | • Servlet 라이프사이클 메서드(`init`, `service`, `destroy`) 동작 확인<br/>• `doGet()`과 `doPost()` 요청 방식에 따른 파라미터 수신 및 분기 처리 | ✅ 완료 |
| **2132** | `WS 02` | • 영화 정보 관리 웹 애플리케이션 환경 구성<br/>• `pom.xml` war 패키징 및 Jakarta Servlet/JSP 의존성 설정 | ✅ 진행 중 |
| **Lab 01** | `BE_01_maven` | • Maven을 활용한 Servlet/JSP 웹 프로젝트 설정<br/>• `jakarta.servlet` 라이브러리 연동 및 구동 | ✅ 완료 |
| **Lab 03** | `BE_03_lab` | • `ControllerHelper` 인터페이스 구현 (`forward`, `redirect` 유틸)<br/>• `MainController` 구구단 비즈니스 로직 연동 및 예외 처리(404, NumberFormatException)<br/>• JSP 기본 문법(`today.jsp` 스크립트릿, 표현식, 선언부) 및 폼 연동 | ✅ 완료 |
| **Lab 04** | `BE_04_lab` | • EL(Expression Language) 문법 및 내장 객체, 연산자 실습<br/>• JSTL(`c:if`, `c:forEach` 등) 태그 라이브러리를 활용한 뷰 구현<br/>• 회원 관리(`MemberController`, Service, DAO) 및 공통 필터/리스너 연동 | ✅ 완료 |
| **Exam** | `Backend_Example` | • 자동차 관리 시스템 종합 실습 (MVC 패턴 구조화)<br/>• 세션 기반 로그인 인증 및 쿠키 기반 `Remember-Me` 구현<br/>• 자동차 등록(`regist`) 및 목록 조회(`list`) 비즈니스 로직 작성 | ✅ 완료 |
| **Solution** | `Backend_Example_sol` | • 자동차 관리 시스템 모범 답안 및 완성형 솔루션 코드 | ✅ 완료 |

<br/>

---

## 🏷 5. Git 커밋 컨벤션 (Commit Convention)

일관되고 명확한 이력 추적을 위해 아래와 같은 커밋 메시지 규칙을 준수합니다.

### 📌 실습 문제 풀이 커밋 형식
```text
solve: [WS {주차}-{단계}] {실습 내용 요약} ({문제번호})
```

**예시**:
```bash
git commit -m "solve: [WS 01-b] 서블릿 생성 및 web.xml/@WebServlet 등록 실습 (3174)"
git commit -m "solve: [WS 01-c] 서블릿 생명주기 및 GET/POST 요청 분기 실습 (3175)"
```

### 📌 기능 개발 및 유지보수 커밋 태그
| 태그 | 설명 | 예시 |
| :--- | :--- | :--- |
| `solve` | 실습 과제 및 워크샵 문제 해결 | `solve: [WS 01-b] 서블릿 등록 실습 (3174)` |
| `feat` | 새로운 기능/클래스/페이지 추가 | `feat: Filter 및 ServletContextListener 구현` |
| `fix` | 버그 수정 또는 오류 해결 | `fix: 한글 파라미터 인코딩 깨짐 현상 수정` |
| `refactor` | 코드 리팩토링 (기능 변경 없음) | `refactor: Front Controller 분기 처리 메서드 추출` |
| `docs` | README 등 문서 작성 및 수정 | `docs: 실습 진행 현황 표 및 디렉토리 구조 업데이트` |
| `chore` | 빌드 스크립트 수정, 패키지 설정 등 | `chore: pom.xml 의존성 최신화` |

<br/>

---

## 💡 6. 실행 및 테스트 방법

1. **저장소 클론**:
   ```bash
   git clone https://github.com/canotlivewithoutyou/SSAFY_BackEnd_Practice.git
   ```
2. **Eclipse / STS로 Import**:
   - `File` > `Import` > `Maven` > `Existing Maven Projects`
   - 원하는 실습 디렉토리(예: `3174`, `3175`, `BE_03_lab`) 선택 후 Import
3. **Tomcat 서버 등록 및 실행**:
   - Eclipse `Servers` 뷰에서 `Tomcat v10.1 Server at localhost` 구성
   - 실행하고자 하는 프로젝트를 우클릭 > `Run As` > `Run on Server`
   - 브라우저를 통해 `http://localhost:8080/{프로젝트경로}/` 접속 확인

<br/>

<div align="center">
  <sub>SSAFY 16기 백엔드 실습 아카이브 | Continually Updated</sub>
</div>
