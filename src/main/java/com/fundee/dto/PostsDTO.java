package com.fundee.dto;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class PostsDTO {
    private int posts_num; // ��ǰ��ȣ(�Խñ� ��ȣ)
    private String price;// ��ǰ���Ű���
    private String userId;// ����� id
    private String title;// ��ǰ ����
    private int goal_amount;// ��ǥ �ݾ�
    private int current_amount; // ���� ��ݾ�
    private String start_date; // �Ǹ� ������
    private String end_date; // �Ǹ� ������
    private String reg_date; // ��ǰ �����
    private String status; // �޼� ���� ����
    private String content;// ��ǰ ����
    private int hitCount; // ��ȸ��
    
    // ���� ���ε� ���� ���� �߰�
    @JsonIgnore
    private MultipartFile upload; // ���� ��ü�� ���� ����
    
    private String image_file;     // ���ϸ��� ���� ����
    
}