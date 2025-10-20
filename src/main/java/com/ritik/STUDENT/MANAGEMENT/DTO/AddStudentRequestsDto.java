package com.ritik.STUDENT.MANAGEMENT.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

public class AddStudentRequestsDto {

         @NotBlank(message = "Name is Required")
         @Size(min = 3 , max =30,message = "Name should be of length 3 to 30 characters")
        private String name;


        @Email
        @NotBlank(message = "Email is Required")
        private String email;




}
