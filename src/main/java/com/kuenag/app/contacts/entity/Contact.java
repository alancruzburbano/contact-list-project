package com.kuenag.app.contacts.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The Entity that represents the data contained in
 * the model object CONTACT
 * NAME: The contact name and surname
 * AVATAR_URL: A link that address to an contact avatar
 *
 * @author Alvaro Andres Cruz Burbano
 */
@Entity(name = "CONTACT")
@Table(name = "CONTACT")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contact {
    @Id
    @SequenceGenerator(name = "seq_contact", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contact")
    private Long id;
    @Getter
    @Setter
    @NonNull
    @Column(name = "NAME", length = 100)
    private String name;
    @Getter
    @Setter
    @Column(name = "AVATAR_URL", length = 300)
    private String urlAvatar;
}
