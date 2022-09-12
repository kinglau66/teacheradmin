package com.king.teacher.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO representing a user, with his authorities.
 */
public class FindCommonStudentDTO implements Serializable {

    List<String> students = new ArrayList<>();

    public FindCommonStudentDTO() {}

    public FindCommonStudentDTO(List<String> students) {
        this.students = students;
    }

    public static FindCommonStudentDTOBuilder builder() {
        return new FindCommonStudentDTOBuilder();
    }

    public List<String> getStudents() {
        return this.students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FindCommonStudentDTO)) return false;
        final FindCommonStudentDTO other = (FindCommonStudentDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$students = this.getStudents();
        final Object other$students = other.getStudents();
        return Objects.equals(this$students, other$students);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FindCommonStudentDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $students = this.getStudents();
        result = result * PRIME + ($students == null ? 43 : $students.hashCode());
        return result;
    }

    public String toString() {
        return "FindCommonStudentDTO(students=" + this.getStudents() + ")";
    }

    public static class FindCommonStudentDTOBuilder {

        private List<String> students;

        FindCommonStudentDTOBuilder() {}

        public FindCommonStudentDTOBuilder students(List<String> students) {
            this.students = students;
            return this;
        }

        public FindCommonStudentDTOBuilder students(Set<String> students) {
            this.students = new ArrayList<>(students);
            return this;
        }

        public FindCommonStudentDTO build() {
            return new FindCommonStudentDTO(students);
        }

        public String toString() {
            return "FindCommonStudentDTO.FindCommonStudentDTOBuilder(students=" + this.students + ")";
        }
    }
}
