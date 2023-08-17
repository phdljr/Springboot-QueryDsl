package kr.ac.phdljr.springbootjpaquerydsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTokens is a Querydsl query type for Tokens
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTokens extends EntityPathBase<Tokens> {

    private static final long serialVersionUID = -1887180858L;

    public static final QTokens tokens = new QTokens("tokens");

    public final BooleanPath expired = createBoolean("expired");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath revoked = createBoolean("revoked");

    public final StringPath token = createString("token");

    public final EnumPath<TokenType> tokenType = createEnum("tokenType", TokenType.class);

    public final StringPath username = createString("username");

    public QTokens(String variable) {
        super(Tokens.class, forVariable(variable));
    }

    public QTokens(Path<? extends Tokens> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTokens(PathMetadata metadata) {
        super(Tokens.class, metadata);
    }

}

