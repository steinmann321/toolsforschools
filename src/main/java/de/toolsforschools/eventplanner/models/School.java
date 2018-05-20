package de.toolsforschools.eventplanner.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class School {
	@Id
	@GeneratedValue
	private Long id;
	private @NonNull String name;
}
