package edu.web.jsp02.dto;

import edu.web.jsp02.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 argument로 갖는 생성자
@Builder // Builder 패턴에서 필요한 내부 클래스와 메서드
@Data // @getter, @setter, @toString, @EqualsandHashcode, @RequiredArgsConstructor
public class UserCreateDto {

    private String name;
    private String password;
    private String email;
    
    public User toEntity() {
        
        return User.builder().name(name).password(password).email(email).build();
    }
    
}
