package ls.example.service.document;

import io.mikael.urlbuilder.UrlBuilder;
import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.CompletableFutures;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

abstract class DocumentServiceBase implements DocumentService
{
    private final ExecutorService executorService;

    DocumentServiceBase(ExecutorService executorService)
    {
        this.executorService = executorService;
    }

    @Override
    public final CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(TextDocumentPositionParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<CompletionItem> resolveCompletionItem(CompletionItem unresolved)
    {
        return null;
    }

    @Override
    public final CompletableFuture<Hover> hover(TextDocumentPositionParams params)
    {
        URI uri = createSafeUri(params.getTextDocument().getUri());
        return CompletableFutures.computeAsync(executorService,
                cancelChecker -> hoverSync(uri, params.getPosition())
        );
    }

    protected Hover hoverSync(URI uri, Position position)
    {
        return new Hover();
    }

    @Override
    public final CompletableFuture<SignatureHelp> signatureHelp(TextDocumentPositionParams position)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends Location>> definition(TextDocumentPositionParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends Location>> references(ReferenceParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends DocumentHighlight>> documentHighlight(TextDocumentPositionParams position)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends SymbolInformation>> documentSymbol(DocumentSymbolParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends Command>> codeAction(CodeActionParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends CodeLens>> codeLens(CodeLensParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<CodeLens> resolveCodeLens(CodeLens unresolved)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends TextEdit>> formatting(DocumentFormattingParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends TextEdit>> rangeFormatting(DocumentRangeFormattingParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<? extends TextEdit>> onTypeFormatting(DocumentOnTypeFormattingParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<WorkspaceEdit> rename(RenameParams params)
    {
        return null;
    }

    @Override
    public final void didOpen(DidOpenTextDocumentParams params)
    {
    }

    @Override
    public final void didChange(DidChangeTextDocumentParams params)
    {
    }

    @Override
    public final void didClose(DidCloseTextDocumentParams params)
    {
    }

    @Override
    public final void didSave(DidSaveTextDocumentParams params)
    {
    }

    @Override
    public final void willSave(WillSaveTextDocumentParams params)
    {
    }

    @Override
    public final CompletableFuture<List<TextEdit>> willSaveWaitUntil(WillSaveTextDocumentParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<List<DocumentLink>> documentLink(DocumentLinkParams params)
    {
        return null;
    }

    @Override
    public final CompletableFuture<DocumentLink> documentLinkResolve(DocumentLink params)
    {
        return null;
    }

    private static URI createSafeUri(String uri)
    {
        return UrlBuilder.fromString(uri).toUri();
    }
}
