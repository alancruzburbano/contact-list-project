package com.kuenag.app.contacts.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.*;

@Entity(name="CONTACT")
@Table(name = "CHARACTER_INFO")
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    @NonNull
    @Column(name = "CONTACT_NAME")
    private String name;
    @Getter
    @Setter
    @Column(name = "AVATAR_URL")
    private String urlAvatar;
}
