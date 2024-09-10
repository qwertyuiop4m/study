package study.data_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class JpaBaseEntity {

    @Column(updatable = false)
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void perPersist(){
        LocalDateTime now=LocalDateTime.now();
        createDate=now;
        updatedDate=now;
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate=LocalDateTime.now();
    }
}
