package de.toolsforschools.eventplanner.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Todolist {
	@Id
	@GeneratedValue
	private Long id;
	private @NonNull String name;
}
