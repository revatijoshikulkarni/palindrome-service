package palindrome.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;
import org.hibernate.annotations.Type;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import palindrome.domain.Palindrome;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


@Component
@Data
@Builder
@Entity
@Table( name = "palindromedata")
@AllArgsConstructor
public class PalindromeData implements Serializable {

    private static final int serialVersionUID = 0;
    @JsonIgnoreProperties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonInclude
    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "payload", columnDefinition = "jsonb")
    private JSONObject payLoad;

    @JsonIgnoreProperties
    @Column(name = "created_timestamp")
    private String createdTimestamp;

    @JsonInclude
    @Column(name = "payloadtext")
    private String payLoadText;

}
