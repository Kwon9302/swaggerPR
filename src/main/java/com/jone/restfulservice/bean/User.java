package com.jone.restfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password","ssn"})
@Entity
@Schema(description = "사용자 상세정보를 위한 도메인 객체")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "사용자 id",  description = "사용자 id자동생성됨")
    private Integer id;

    @Schema(title = "사용자 id",  description = "사용자 이름생성됨")
    @Size(min =2, message = "Name은 2글자 이상 입력해주세요")
    private String name;

    @Schema(title = "사용자 id",  description = "사용자 등록일을 입력합니다")
    @Past(message="등록일은 미래 날짜 입력X")
    private Date joinDate;

    @Schema(title = "사용자 id",  description = "비번입렵")
    private String password;
    @Schema(title = "사용자 id",  description = "ssn입력")
    private String ssn;
}
