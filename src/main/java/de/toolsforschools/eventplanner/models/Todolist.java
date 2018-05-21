package de.toolsforschools.eventplanner.models;

import lombok.*;

import javax.persistence.*;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	private @NonNull Event event;
}
