package locus.server.infra.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TransformStatus {

    TRANSFORM_SUCCESS(1),

    TRANSFORM_FAIL(2),

    REDIRECTION_SUCCESS(3),

    REDIRECTION_FAIL(4);

    private Integer value;

}
